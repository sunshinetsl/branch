package com.dragon.controller.community;

import com.dragon.common.util.FunctionConstants;
import com.dragon.entity.HomeImpress;
import com.dragon.service.community.HomeImpressService;
import com.dragon.service.func.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragon.common.BasicContorller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import com.dragon.entity.Area;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
			MultipartResolver resoler = new CommonsMultipartResolver(request.getSession().getServletContext());
			MultipartHttpServletRequest multipartRequest = resoler.resolveMultipart(request);
			MultipartFile file = multipartRequest.getFile("fileList");
			System.out.print(file);
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


	/**
	 * 上传图片
	 * @return
	 */
	@RequestMapping("/upload.do")
	public ModelAndView upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//		MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
//		MultipartFile file = multipartRequest.getFile("fileList");
//		System.out.print(file);
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				if (file != null) {
					String fileName = file.getOriginalFilename();

//					file.
				}

			}

		}
		return new ModelAndView("success");
	}

}
