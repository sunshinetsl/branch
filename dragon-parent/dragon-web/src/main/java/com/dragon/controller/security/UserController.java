package com.dragon.controller.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dragon.common.BasicContorller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dragon.common.page.PageResultSet;
import com.dragon.common.util.Constants;
import com.dragon.common.util.Util;
import com.dragon.dto.UserModel;
import com.dragon.entity.User;
import com.dragon.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController extends BasicContorller{

	@Autowired
	private UserService userService;
	
	@RequestMapping("/userLogin")
	public String userLogin(UserModel userModel, Model model){
		userModel.setPassword(Util.encryptMD5(userModel.getPassword()));
		User user = userService.findUserByByCondition(userModel);
		if (user == null) {
			model.addAttribute("errorInfo", "you password is error!");
			return "login";
		}
		
		Constants.LOGIN_USER = user.getUsername();
		return "redirect:/user/index";
	}
	@RequestMapping("/addUser")
	public String addUser(UserModel userModel){
		Date date = new Date();
		User user = new User();
		BeanUtils.copyProperties(userModel, user); //瀹炰綋灞炴�澶嶅埗锛屽皢userModel涓殑灞炴�鍊煎鍒跺埌User涓�
		user.setPassword(Util.encryptMD5(userModel.getPassword()));
		user.setCreateTime(date);
		user.setUpdateTime(date);
		user.setUpdateUser(Constants.LOGIN_USER);
		user.setCreateUser(Constants.LOGIN_USER);
		userService.saveUser(user);
		return "redirect:/user/index";
	}
	@RequestMapping("/index")
	public ModelAndView index(UserModel userModel, HttpServletRequest request) {  
		if(Util.isNull(Constants.LOGIN_USER)){
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("errorInfo", "user is overdue!");
			return mav;
		}
	    return new ModelAndView("userList");  
	 }  
	
	@RequestMapping("/getUser")
	public void getUser(HttpServletRequest request, HttpServletResponse response, Model model) {  
	    int id = Integer.parseInt(request.getParameter("userId"));
	    User user = userService.getUserById(id);
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("user", user);
	    model.addAttribute("user", user);
	 }  
	
	@RequestMapping("/updateUser")
	public String updateUser(UserModel userModel){
		Date date = new Date();
		User user = userService.getUserById(userModel.getId());
		if (Util.isNull(userModel.getPassword())) {
			userModel.setPassword(user.getPassword());
		}else {
			userModel.setPassword(Util.encryptMD5(userModel.getPassword()));
		}
		userModel.setCreateTime(user.getCreateTime());
		userModel.setUpdateTime(date);
		userModel.setCreateUser(Constants.LOGIN_USER);
		userModel.setUpdateUser(Constants.LOGIN_USER);
		BeanUtils.copyProperties(userModel, user);
		userService.updateUser(user);
		return "redirect:/user/index";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request){
		  int id = Integer.parseInt(request.getParameter("userId"));
		  User user = userService.getUserById(id);
		  userService.deleteUser(user);
		  return "redirect:/user/index";
	}
	
	@RequestMapping("/exit")
	public String exit(){
		Constants.LOGIN_USER = null;
		return "redirect:/";
	}
	//杩斿洖json
	@RequestMapping("/getJsonUserList")
	@ResponseBody
	public ModelMap getJsonUserList(UserModel userModel, HttpServletRequest request, HttpServletResponse response) {
		ModelMap modelMap = new ModelMap();
		response.setHeader("Access-Control-Allow-Origin", "*");
		String sPage = request.getParameter("page");
		int page = 1;
		if (!Util.isNull(sPage)) {
			page = Integer.parseInt(sPage);
		}
		PageResultSet<User> userPageResult = userService.findPageUserList(userModel, page, Constants.PAGE_SIZE);
		
		modelMap.addAttribute("event",userPageResult.getList());
		modelMap.addAttribute("pageBean", userPageResult.getPage());
		modelMap.addAttribute("pageCount",userPageResult.getPage().getTotalPage());
		return modelMap;
	}
	  
}
