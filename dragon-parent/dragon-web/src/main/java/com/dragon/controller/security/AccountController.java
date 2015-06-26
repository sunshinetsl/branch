package com.dragon.controller.security;

import com.dragon.bean.UserSessionInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dragon.common.BasicContorller;
import com.dragon.dto.MessageDTO;
import com.dragon.entity.UserInfo;
import com.dragon.service.account.AccountService;
import org.springframework.web.servlet.ModelAndView;

/**
 * 账号管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BasicContorller{

	private Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserDetailsService securityUserService;
	
	private MessageDTO msg = new MessageDTO();
	
	private ModelMap model = new ModelMap();


	/**
	 * 登陆页面
	 * @return
	 */
	@RequestMapping("/loginPage")
	public ModelAndView loginPage(){
		logger.debug("进入登录页面 -->start");
		return new ModelAndView("/account/loginPage");
	}



	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("/reg")
	@ResponseBody
	public ModelMap reg(String account, String passWord, String rePassWord){
		if(logger.isDebugEnabled()){
			logger.debug("reg (account={},passWord={},rePassWord={})",account, passWord, rePassWord);
		}
		int count = accountService.checkAccount(account);
		if(count > 0){
			msg.setFlag("1");
			msg.setCause("用户名已存在");
			model.addAttribute("callBack",msg);
			return model;
		}
		if(!passWord.equals(rePassWord)){
			msg.setFlag("1");
			msg.setCause("两次密码输入不一样");
			model.addAttribute("callBack",msg);
			return model;
		}
		int sign = accountService.saveRegAccount(account,passWord);
		if(sign > 0){
			msg.setFlag("0");
			msg.setCause("注册成功");
			model.addAttribute("callBack",msg);
			UserInfo user = accountService.queryAccount(account);
			securityUserService.loadUserByUsername(user.getAccount());
		}else{
			msg.setFlag("1");
			msg.setCause("注册失败");
			model.addAttribute("callBack",msg);
		}
		return model;
	}

	
	
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/check")
	@ResponseBody
	public ModelMap check(String username, String password){
		logger.debug("login(account={},passWord={} -->start)",username,password);
		UserInfo user = accountService.queryAccount(username);
		if(null == user){
			msg.setFlag("1");
			msg.setCause("用户名不存在");
			model.addAttribute("callBack",msg);
			return model;
		}
		if(!DigestUtils.md5Hex(password).equals(user.getPassWord())){
			msg.setFlag("1");
			msg.setCause("密码错误");
			model.addAttribute("callBack",msg);
			return model;
		}
		msg.setFlag("0");
		msg.setCause("登录成功");
		model.addAttribute("callBack",msg);
		//securityUserService.loadUserByUsername(user.getAccount());
		return model;
	}

	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/userLogin")
	public ModelAndView userLogin(String username, String password){
		logger.debug("login(account={},passWord={} -->start)",username,password);
		UserSessionInfo userInfo = (UserSessionInfo)securityUserService.loadUserByUsername(username);
		return new ModelAndView("redirect:/j_spring_security_check");
	}

	/**
	 * 注销登录
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(){
		if(logger.isDebugEnabled()){
			logger.debug("logout");
		}
		return "redirect:../homePage.html";
	}
}
