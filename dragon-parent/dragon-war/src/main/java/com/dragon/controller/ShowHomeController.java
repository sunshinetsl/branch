package com.dragon.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页转向
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="home")
public class ShowHomeController {
	
	private Logger logger = LoggerFactory.getLogger(ShowHomeController.class);
	
	@Autowired  
	private  HttpServletRequest request;  
	
	/**
	 * 转向方法
	 * @return
	 */
	@RequestMapping(value="show")
	public String showHome(){
		logger.info("showHome -->start");
		return "redirect:/homePage.html";
	}
}
