package com.dragon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dragon.common.BasicContorller;

/**
 * 主页转向
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/home")
public class ShowHomeController extends BasicContorller{
	
	private Logger logger = LoggerFactory.getLogger(ShowHomeController.class);

	
	/**
	 * 转向方法
	 * @return
	 */
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String showHome(){
		logger.info("showHome -->start");
		return "redirect:/homePage.html";
	}
}
