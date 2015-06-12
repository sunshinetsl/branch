package com.dragon.common.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.dragon.bean.UserSessionInfo;
import com.dragon.common.BasicContorller;

public class AuditProvider extends BasicContorller {

	@Autowired
	private UserDetailsService securityUserService;
	
	/**
	 * 检查session
	 * @param accout
	 * @return
	 */
	public UserDetails securityProvider(String accout){
		SecurityContext context = SecurityContextHolder.getContext();
		UserSessionInfo user = (UserSessionInfo) context.getAuthentication().getPrincipal();
		if(null == user){
			user = (UserSessionInfo) securityUserService.loadUserByUsername(accout);
		}
		return user;
	}
}
