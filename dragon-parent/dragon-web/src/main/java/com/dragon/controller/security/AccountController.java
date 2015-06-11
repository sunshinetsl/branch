package com.dragon.controller.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dragon.common.BasicContorller;
import com.dragon.dto.MessageDTO;
import com.dragon.entity.UserInfo;
import com.dragon.service.account.AccountService;

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
	
	private MessageDTO msg = new MessageDTO();
	
	private ModelMap model = new ModelMap();
	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping("/regPage")
	public String regPage(){
		if(logger.isDebugEnabled()){
			logger.debug("regPage -->start");
		}
		return "account/regPage";
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
		}else{
			msg.setFlag("1");
			msg.setCause("注册失败");
			model.addAttribute("callBack",msg);
		}
		return model;
	}
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/loginPage")
	public String loginPage(){
		if(logger.isDebugEnabled()){
			logger.debug("loginPage -->start");
		}
		return "account/loginPage";
	}
	
	
	/**
	 * 登录
	 * @param account
	 * @param passWord
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ModelMap login(String account, String passWord){
		logger.debug("login(account={},passWord={} -->start)",account,passWord);
		UserInfo user = accountService.queryAccount(account);
		if(null == user){
			msg.setFlag("1");
			msg.setCause("用户名不存在");
			model.addAttribute("callBack",msg);
			return model;
		}
		if(!DigestUtils.md5Hex(passWord).equals(user.getPassWord())){
			msg.setFlag("1");
			msg.setCause("密码错误");
			model.addAttribute("callBack",msg);
			return model;
		}
		msg.setFlag("0");
		msg.setCause("登录成功");
		model.addAttribute("callBack",msg);
		accountService.setUserSession(user,super.getRequest());
		return model;
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
