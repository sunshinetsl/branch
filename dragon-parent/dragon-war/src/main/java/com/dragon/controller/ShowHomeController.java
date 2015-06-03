package com.dragon.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dragon.entity.Goods;
import com.dragon.service.UserService;

@Controller
@RequestMapping(value="home")
public class ShowHomeController {

	@Autowired
	private UserService userService;
	
	@Autowired  
	private  HttpServletRequest request;  
	
	@RequestMapping(value="/community/show")
	public ModelAndView showHome(){
		Goods goods = userService.getTest(1);
		return new ModelAndView("community/homePage");
	}
}
