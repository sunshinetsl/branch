package com.dragon.controller.community;

import com.dragon.common.util.FunctionConstants;
import com.dragon.service.func.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragon.common.BasicContorller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.dragon.entity.Area;
import java.util.List;

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
	public ModelAndView announce(@RequestParam("theme") String theme, @RequestParam("content") String content, @RequestParam("areaId") String areaId){
		if(logger.isDebugEnabled()){
			logger.debug("announce -->start");
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("");
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
			logger.debug("getDistrict (province = {} , city = {})",province,city);
		}
		List<Area> areaList = areaService.getDistrict(province, city, FunctionConstants.OFTEN_STATUS_ACTIVE);
		ModelMap map = new ModelMap();
		map.addAttribute("district",areaList);
		return map;
	}
}
