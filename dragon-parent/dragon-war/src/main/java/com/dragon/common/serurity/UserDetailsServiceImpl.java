package com.dragon.common.serurity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dragon.bean.UserSessionInfo;
import com.dragon.common.BasicContorller;
import com.dragon.entity.UserInfo;
import com.dragon.service.account.AccountService;

/**
 * serurity 实现
 * @author Administrator
 *
 */
@Service("securityUserService")
public class UserDetailsServiceImpl extends BasicContorller implements UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		if(logger.isDebugEnabled()){
			logger.debug("loadUserByUsername(username = {}) --start",account);
		}
		UserInfo user = accountService.queryAccount(account);
		setUserSession(user);
		if(!user.getAccount().equals(account)){
			return null;
		}
		// Spring Security授权
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(1);
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getAccount(), user.getPassWord(), authorities);
		SecurityContext context = new SecurityContextImpl();
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.print(obj);
		return super.getSessionUserInfo();
	}
	
	/**
	 * 放置session
	 * @param user
	 */
	public void setUserSession(UserInfo user) {
		UserSessionInfo sessionInfo = (UserSessionInfo) super.getRequest().getSession().getAttribute("userSessionInfo");
		if (sessionInfo == null) {
			sessionInfo = new UserSessionInfo();
			sessionInfo.setUserId(user.getId());
			sessionInfo.setNickName(user.getNickName());
			sessionInfo.setMobile(user.getMobile());
			sessionInfo.setAccount(user.getAccount());
			sessionInfo.setEmail(user.getEmail());
			sessionInfo.setSex(user.getSex());
			sessionInfo.setStatusCode(user.getStatusCode());
			sessionInfo.setPassWord(user.getPassWord());
			super.getRequest().getSession().setAttribute("userSessionInfo", sessionInfo);
		}
		/************************************/
		logger.debug("userid{}", sessionInfo.getUserId());
	}

}
