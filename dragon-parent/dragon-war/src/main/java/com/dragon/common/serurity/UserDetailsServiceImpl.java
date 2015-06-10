package com.dragon.common.serurity;

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return null;
	}

}
