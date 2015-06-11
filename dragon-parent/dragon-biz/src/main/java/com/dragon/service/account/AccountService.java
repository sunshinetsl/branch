package com.dragon.service.account;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.dragon.entity.UserInfo;

/**
 * 账号逻辑层
 * @author Administrator
 *
 */
@Service("accountService")
public interface AccountService {

	/**
	 * 验证账号是否存在
	 * @param account
	 * @return
	 */
	int checkAccount(String account);

	/**
	 * 注册 入库
	 * @param account
	 * @param passWord
	 * @return
	 */
	int saveRegAccount(String account, String passWord);

	/**
	 * 查询账号信息
	 * @param account
	 * @return
	 */
	UserInfo queryAccount(String account);

	/**
	 * 设置session信息
	 * @param user
	 */
	void setUserSession(UserInfo user, HttpServletRequest request);

	/**
	 * 根据用户ID查询
	 * @param userid
	 * @return
	 */
	UserInfo selectUserInfoByPrimaryKey(Integer userid);

}
