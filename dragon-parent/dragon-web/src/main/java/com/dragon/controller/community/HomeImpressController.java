package com.dragon.controller.community;

import com.dragon.common.util.FunctionConstants;
import com.dragon.common.util.Util;
import com.dragon.entity.HomeImpress;
import com.dragon.entity.ImageRepository;
import com.dragon.service.community.HomeImpressService;
import com.dragon.service.community.ImageRepositoryService;
import com.dragon.service.func.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragon.common.BasicContorller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import com.dragon.entity.Area;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 家乡印象
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/homeImpress")
public class HomeImpressController extends BasicContorller{

	private Logger logger = LoggerFactory.getLogger(HomeImpressController.class);

	@Autowired
	private AreaService areaService;

	@Autowired
	private HomeImpressService homeImpressService;

	@Autowired
	private ImageRepositoryService imageRepositoryService;

	/**
	 * 家乡首页
	 * @return
	 */
	@RequestMapping("/page")
	public String homeImpressPage(){
		if(logger.isDebugEnabled()){
			logger.debug("homeImpressPage -->start");
		}
		return "/community/homeImpress/homeImpressPage";
	}
	
	/**
	 * 发布页
	 * @return
	 */
	@RequestMapping("/announcePage")
	public ModelAndView announcePage(){
		if(logger.isDebugEnabled()){
			logger.debug("announce -->start");
		}
		List<Area> areaList = areaService.queryByAllProvince(FunctionConstants.OFTEN_STATUS_ACTIVE);
		ModelAndView model = new ModelAndView();
		model.setViewName("/community/homeImpress/announcePage");
		model.addObject("province", areaList);
		logger.debug("areaList (areaList = {})",areaList);
		return model;
	}

	/**
	 * 发布家乡印象
	 * @return
	 */
	@RequestMapping("/announce")
	public ModelAndView announce(@ModelAttribute HomeImpress homeImpress, HttpServletRequest request){
		if(logger.isDebugEnabled()){
			logger.debug("announce -->start");
		}
		homeImpress.setUserId(super.getSessionUserInfo().getUserId());

		//保存印象发布表
		int count = homeImpressService.saveHomeImpress(homeImpress);
		//保存图片表
		if(count > 0){
			try {
				//文件存储地址
				String narmalFilePath = FunctionConstants.NARMAL_FILE_PATH;
				String smallFilePath = FunctionConstants.SMALL_FILE_PATH;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String dateStr = format.format(new Date());
				//替换文件来源
				String narmalPath = narmalFilePath.replaceAll("FILE-SOURCE","homeImpress").replaceAll("DATE-STR", dateStr).replaceAll("USER-ID",super.getSessionUserInfo().getUserId().toString());
				String smallPath = smallFilePath.replaceAll("FILE-SOURCE","homeImpress").replaceAll("DATE-STR", dateStr).replaceAll("USER-ID",super.getSessionUserInfo().getUserId().toString());
				CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                        request.getSession().getServletContext());
				if (multipartResolver.isMultipart(request)) {
                    MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

					List<MultipartFile> fileList = multiRequest.getFiles("fileList");
					for(MultipartFile file : fileList){
						if(file != null){
							//保存图片
							Random dom = new Random();
							//文件名称
							long times = System.currentTimeMillis();
							long imageName = times + dom.nextInt(1000);
							boolean flag = Util.SaveFileFromInputStream(file.getInputStream(), narmalPath, imageName, file.getContentType());
							if(!flag){
								break;
							}else{

								String newPath = narmalPath + File.separator + imageName + Util.getImageType(file.getContentType());
								String smallNewpath = smallPath + File.separator + imageName + Util.getImageType(file.getContentType());
								BufferedImage bufferedImage = ImageIO.read(new File(newPath));
								try {
									Util.reduceImage(newPath,smallNewpath,
											(int) (bufferedImage.getWidth() * 1),
											(int) (bufferedImage.getHeight() * 1));
								} catch (Exception e) {
									e.printStackTrace();
								}
								//保存图片表数据
								ImageRepository repository = new ImageRepository();
								repository.setImgType(FunctionConstants.HOME_IMPRESS);
								repository.setImageAddress(path + File.separator + imageName);
								repository.setSourceId(count);
								repository.setSmallImageAddress(smallPath + File.separator + imageName);
								int i = imageRepositoryService.saveImages(repository);
								if(i <= 0){
									throw new IllegalArgumentException("保存图片异常");
								}
							}
						}
					}
                }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ModelAndView model = new ModelAndView();
		model.setViewName("/homeImpress/announcePage");
		return model;
	}

	/**
	 * 根据省查询市
	 * @return
	 */
	@RequestMapping("/getCity")
	@ResponseBody
	public ModelMap getCity(@RequestParam("province") String province){
		if(logger.isDebugEnabled()){
			logger.debug("getCity (province = {})",province);
		}
		List<Area> areaList = areaService.getCityByProvince(province,FunctionConstants.OFTEN_STATUS_ACTIVE);
		ModelMap map = new ModelMap();
		map.addAttribute("city",areaList);
		return map;
	}


	/**
	 * 查区
	 * @param province
	 * @param city
	 * @return
	 */
	@RequestMapping("/getDistrict")
	@ResponseBody
	public ModelMap getDistrict(@RequestParam("province") String province, @RequestParam("city") String city){
		if(logger.isDebugEnabled()){
			logger.debug("getDistrict (province = {} , city = {})", province, city);
		}
		List<Area> areaList = areaService.getDistrict(province, city, FunctionConstants.OFTEN_STATUS_ACTIVE);
		ModelMap map = new ModelMap();
		map.addAttribute("district",areaList);
		return map;
	}


}
