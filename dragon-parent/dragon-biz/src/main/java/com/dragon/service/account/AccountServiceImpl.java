package com.dragon.service.account;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

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
	@Override
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
	@Override
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
	@Override
	public UserInfo queryAccount(String account) {
		UserInfo user = null;
		if(StringUtils.isBlank(account)){
			return user;
		}
		user = accountDAO.queryAccount(account);
		return user;
	}

}
