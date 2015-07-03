package com.dragon.controller.community;

import com.dragon.common.util.FunctionConstants;
import com.dragon.common.util.Util;
import com.dragon.dto.BaseSearchConditionDTO;
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
import org.springframework.web.servlet.ModelAndView;
import com.dragon.entity.Area;
import javax.servlet.http.HttpServletRequest;
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
	public ModelAndView homeImpressPage(){
		if(logger.isDebugEnabled()){
			logger.debug("homeImpressPage -->start");
		}
		BaseSearchConditionDTO searchDTO = new BaseSearchConditionDTO();
		searchDTO.setCountPerPage(10);
		searchDTO.setPageIndex(1);
		//查询家乡印象列表，分页
		BaseSearchConditionDTO resultDTO = homeImpressService.selectHomeImpressList(searchDTO);
		ModelAndView model = new ModelAndView();
		model.setViewName("/community/homeImpress/homeImpressPage");
		model.addObject("result", resultDTO);
		model.addObject("rootFilePath",FunctionConstants.ROOT_FILE_PATH);
		return model;
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
			//文件存储地址
			String narmalFilePath = FunctionConstants.NARMAL_FILE_PATH;
			String smallFilePath = FunctionConstants.SMALL_FILE_PATH;
			String rootPath = FunctionConstants.ROOT_FILE_PATH;
			String[][] reback = Util.upload(narmalFilePath, smallFilePath, super.getSessionUserInfo(), request,rootPath);
			for(int i = 0; i < reback.length; i++){
				HomeImpress impress = new HomeImpress();
				impress.setId(count);
				//保存图片表数据
				ImageRepository repository = new ImageRepository();
				repository.setImgType(FunctionConstants.HOME_IMPRESS);
				repository.setImageAddress(reback[i][0]);
				repository.setHomeImpress(homeImpress);
				repository.setSmallImageAddress(reback[i][1]);
				int j = imageRepositoryService.saveImages(repository);
				if(j <= 0){
					throw new IllegalArgumentException("保存图片异常");
				}
			}
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/homeImpress/page.html");
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

	/**
	 * 查看详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/detils")
	public ModelAndView getDetils(String id){
		if(logger.isDebugEnabled()){
			logger.debug("getDetils (id = {})", id);
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("/community/homeImpress/homeImpressDetils");
		return model;
	}

}
