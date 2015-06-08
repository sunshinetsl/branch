package com.dragon.service.account;

import org.springframework.stereotype.Service;

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

}
