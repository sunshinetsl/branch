package com.dragon.controller.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主页
 * @author Administrator
 *
 */
@Controller
public class IntroduceController {

	@RequestMapping("homePage")
	public ModelAndView homePage(){
		return new ModelAndView("about/homePage");
	}
}
