package com.dragon.controller.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dragon.common.BasicContorller;

/**
 * 主页
 * @author Administrator
 *
 */
@Controller
public class IntroduceController extends BasicContorller{

	@RequestMapping("/homePage")
	public ModelAndView homePage(){
		this.getSessionUserInfo();
		return new ModelAndView("about/homePage");
	}
}
