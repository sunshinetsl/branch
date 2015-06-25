package com.dragon.service.account;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	 * 检查账号
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
	 * 保存
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
