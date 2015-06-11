package com.dragon.dao.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.common.dao.BaseDAO;
import com.dragon.entity.UserInfo;

@Repository
public class AccountDAO<T> extends BaseDAO<T>{

	private Logger logger = LoggerFactory.getLogger(AccountDAO.class);
	
	/**
	 * 检查账号是否存在
	 * @param account
	 * @return
	 */
	public int checkAccount(String account) {
		StringBuilder builder = new StringBuilder();
		builder.append("from UserInfo u where 1=1");
		if(StringUtils.isNotBlank(account)){
			builder.append(" and u.account = '").append(account).append("'");
		}
		String hql = builder.toString();
		int count = super.count(hql).intValue();
		logger.debug("count={}",count);
		return count;
	}

	/**
	 * 注册入库
	 * @param account
	 * @param password
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public int regAccount(String account, String password) {
		UserInfo user = new UserInfo();
		user.setAccount(account);
		user.setPassWord(password);
		user.setCreateTime(new Date());
		int sign = 0;
		try {
			sign = super.save((T) user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign;
	}

	/**
	 * 查询账号信息
	 * @param account
	 * @return
	 */
	public UserInfo queryAccount(String account) {
		StringBuilder builder = new StringBuilder();
		builder.append("from UserInfo u where 1=1 ");
		List<Object> list = new ArrayList<Object>();
		if(StringUtils.isNotBlank(account)){
			builder.append(" and u.account = ?");
			list.add(account);
		}
		String hql = builder.toString();
		UserInfo user = (UserInfo) super.get(hql, list.toArray());
		return user;
	}

	/**
	 * 根据用户ID查询
	 * @param userId
	 * @return
	 */
	public UserInfo selectUserInfoByPrimaryKey(Integer userId) {
		StringBuilder builder = new StringBuilder();
		builder.append("from UserInfo u where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(null != userId && 0 != userId){
			builder.append(" and u.id = ?");
			params.add(userId);
		}
		String hql = builder.toString();
		UserInfo user = (UserInfo) super.get(hql, params);
		return user;
	}

}
