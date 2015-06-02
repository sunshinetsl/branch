package com.dragon.contorller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dragon.entity.Goods;
import com.dragon.service.UserService;

@RestController
@RequestMapping(value="home")
public class ShowHomeContorller {

	@Autowired
	private UserService userService;
	
	@Autowired  
	private  HttpServletRequest request;  
	
	@RequestMapping(value="show")
	public ModelAndView showHome(){
		Goods goods = userService.getTest(1);
		return new ModelAndView("community/homePage");
	}
}
