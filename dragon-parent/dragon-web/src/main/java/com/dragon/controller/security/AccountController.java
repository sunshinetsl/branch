package com.dragon.controller.security;

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

	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping("regPage")
	public String regPage(){
		return null;
	}
}
