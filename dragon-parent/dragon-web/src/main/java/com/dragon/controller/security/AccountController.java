package com.dragon.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 账号管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping
public class AccountController {

	private Logger logger = LoggerFactory.getLogger(AccountController.class);
	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping("regPage")
	public String regPage(){
		if(logger.isDebugEnabled()){
			logger.debug("regPage -->start");
		}
		return null;
	}
}
