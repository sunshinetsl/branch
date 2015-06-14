package com.dragon.controller.community;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragon.common.BasicContorller;

/**
 * 家乡印象
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/homeImpress")
public class HomeImpressController extends BasicContorller{

	private Logger logger = LoggerFactory.getLogger(HomeImpressController.class);
	
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
	 * 发布
	 * @return
	 */
	@RequestMapping("/announce")
	public String announce(){
		if(logger.isDebugEnabled()){
			logger.debug("announce -->start");
		}
		return "/community/homeImpress/announce";
	}
	
}
