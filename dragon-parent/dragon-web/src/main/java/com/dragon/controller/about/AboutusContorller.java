package com.dragon.controller.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 关于
 * @author Administrator
 *
 */

@Controller
@RequestMapping("about")
public class AboutusContorller {

	@RequestMapping("/page")
	public ModelAndView toAboutPage(){
		return new ModelAndView("community/aboutPage");
	}
}
