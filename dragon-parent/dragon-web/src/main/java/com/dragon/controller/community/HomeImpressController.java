package com.dragon.controller.community;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragon.common.BasicContorller;

@Controller
@RequestMapping("/homeImpress")
public class HomeImpressController extends BasicContorller{

	private Logger logger = LoggerFactory.getLogger(HomeImpressController.class);
	
	@RequestMapping("/page")
	public String homeImpressPage(){
		if(logger.isDebugEnabled()){
			logger.debug("homeImpressPage -->start");
		}
		return "/community/homeImpress";
	}
	
}
