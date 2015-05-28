package com.dragon.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="home")
public class ShowHomeContorller {

	@RequestMapping(value="show")
	public ModelAndView showHome(){
		return new ModelAndView("success");
	}
}
