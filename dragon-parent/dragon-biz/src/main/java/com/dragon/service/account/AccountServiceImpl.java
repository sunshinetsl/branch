package com.dragon.service.account;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Service;

import com.dragon.bean.UserSessionInfo;
import com.dragon.dao.account.AccountDAO;
import com.dragon.entity.UserInfo;


/**
 * 账号逻辑层实现
 * @author Administrator
 * @param <T>
 *
 */
@Service("accountServiceImpl")
public class AccountServiceImpl<T> implements AccountService{

	private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountDAO<T> accountDAO;
	
	/**
	 * 
	 */
	public int checkAccount(String account) {
		if(logger.isDebugEnabled()){
			logger.debug("checkAccount -->start");
		}
		int reBack = 0;
		if(StringUtils.isBlank(account)){
			return reBack;
		}
		reBack = accountDAO.checkAccount(account);
		return reBack;
	}

	/**
	 * 
	 */
	public int saveRegAccount(String account, String passWord) {
		int sign = 0;
		if(StringUtils.isBlank(account) || StringUtils.isBlank(passWord)){
			return sign;
		}
		sign = accountDAO.regAccount(account,DigestUtils.md5Hex(passWord));
		return sign;
	}

	/**
	 * 查询账号信息
	 */
	public UserInfo queryAccount(String account) {
		UserInfo user = null;
		if(StringUtils.isBlank(account)){
			return user;
		}
		user = accountDAO.queryAccount(account);
		return user;
	}

	/**
	 * 设置登录信息
	 */
	@Override
	public void setUserSession(UserInfo user, HttpServletRequest request) {
		// Spring Security授权
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(1);
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getId(), user.getPassWord(), authorities);
		SecurityContext context = new SecurityContextImpl();
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);
		UserSessionInfo sessionInfo = (UserSessionInfo) request.getSession().getAttribute("userSessionInfo");
		if (sessionInfo == null) {
			UserInfo userInfo = this.selectUserInfoByPrimaryKey(user.getId());

			sessionInfo = new UserSessionInfo();
			sessionInfo.setUserId(userInfo.getId());
			sessionInfo.setUserName(userInfo.getUserName());
			sessionInfo.setMobile(userInfo.getMobile());
			sessionInfo.setAccount(userInfo.getAccount());
			sessionInfo.setEmail(userInfo.getEmail());
			sessionInfo.setSex(userInfo.getSex());
			sessionInfo.setStatusCode(userInfo.getStatusCode());
			request.getSession().setAttribute("userSessionInfo", sessionInfo);
		}
		/************************************/
		logger.debug("userid{}", sessionInfo.getUserId());
	}

	/**
	 * 根据用户ID查询
	 */
	@Override
	public UserInfo selectUserInfoByPrimaryKey(Integer userId){
		if(null == userId){
			throw new RuntimeException("用户ID为空");
		}
		UserInfo user = accountDAO.selectUserInfoByPrimaryKey(userId);
		return user;
	} 
	
}
