package com.dragon.common.serurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * serurity 实现
 * @author Administrator
 *
 */
@Service("securityUserService")
public class UserDetailsServiceImpl implements UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
//	private 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(logger.isDebugEnabled()){
			logger.debug("loadUserByUsername(username = {}) --start",username);
		}
		Object principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails) principal;
		userDetails.getUsername();
		return null;
	}

}
