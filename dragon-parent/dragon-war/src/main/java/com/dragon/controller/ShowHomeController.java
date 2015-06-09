package com.dragon.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("/show")
	public String showHome(){
		logger.info("showHome -->start");
		System.out.println(super.getRequest().getContextPath());
		return "redirect:/homePage.html";
	}
}
