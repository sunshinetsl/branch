package com.dragon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.common.dao.BaseDAO;
import com.dragon.common.page.Page;
import com.dragon.common.page.PageResultSet;
import com.dragon.common.util.Util;
import com.dragon.entity.User;
import com.dragon.model.UserModel;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private BaseDAO<User> userDao;
	
	public void saveUser(User user) {
		userDao.save(user);
	}

	public void updateUser(User user) {
		userDao.update(user);
	}

	public void deleteUser(User user) {
		userDao.delete(user);
	}

	public List<User> findAllUserList() {

		return userDao.find("from User u order by u.createTime desc");
	}

	public List<User> findUserListByCondition(UserModel userModel) {
		StringBuffer hql = new StringBuffer("from User u where 1=1");
		List<Object> paramList = new ArrayList<Object>();
		if(!Util.isNull(userModel.getUsername())){
			hql.append(" and u.username = ?");
			paramList.add(userModel.getUsername());
		}
			
		if(!Util.isNull(userModel.getPassword())){
			hql.append(" and u.password = ?");
			paramList.add(userModel.getPassword());
		} 
		if(!Util.isNull(userModel.getEmail())){
			hql.append(" and u.email = ?");
			paramList.add(userModel.getEmail());
		} 
		
		if(!Util.isNull(userModel.getUpdateUser())) {
			hql.append(" and u.updateUser = ?");
			paramList.add(userModel.getUpdateUser());
		}
		if(!Util.isNull(userModel.getCreateUser())){
			hql.append(" and u.createUser = ?");
			paramList.add(userModel.getCreateUser());
		} 
		if (userModel.getSex() != null) {
			hql.append(" and u.sex = ?");
			paramList.add(userModel.getSex());
		}
		return userDao.find(hql.toString(), paramList);
	}

	public User findUserByByCondition(UserModel userModel) {
		StringBuffer hql = new StringBuffer("from User u where 1=1");
		List<Object> paramList = new ArrayList<Object>();
		if(!Util.isNull(userModel.getUsername())){
			hql.append(" and u.username = ?");
			paramList.add(userModel.getUsername());
		}
			
		if(!Util.isNull(userModel.getPassword())){
			hql.append(" and u.password = ?");
			paramList.add(userModel.getPassword());
		} 
		if(!Util.isNull(userModel.getEmail())){
			hql.append(" and u.email = ?");
			paramList.add(userModel.getEmail());
		} 
		
		if(!Util.isNull(userModel.getUpdateUser())) {
			hql.append(" and u.updateUser = ?");
			paramList.add(userModel.getUpdateUser());
		}
		if(!Util.isNull(userModel.getCreateUser())){
			hql.append(" and u.createUser = ?");
			paramList.add(userModel.getCreateUser());
		} 
		if (userModel.getSex() != null) {
			hql.append(" and u.sex = ?");
			paramList.add(userModel.getSex());
		}
		if (paramList.size() == 0) {
			return null;
		}
		return userDao.get(hql.toString(), paramList.toArray());
	}

	public User getUserById(int id) {
		return userDao.get(User.class, id);
	}

	public PageResultSet<User> findPageUserList(UserModel userModel, int page,
			int pageSize) {
		
		StringBuffer hql = new StringBuffer("from User u where 1=1");
		List<Object> paramList = new ArrayList<Object>();
		if(!Util.isNull(userModel.getUsername())){
			hql.append(" and u.username = ?");
			paramList.add(userModel.getUsername());
		}
			
		if(!Util.isNull(userModel.getPassword())){
			hql.append(" and u.password = ?");
			paramList.add(userModel.getPassword());
		} 
		if(!Util.isNull(userModel.getEmail())){
			hql.append(" and u.email = ?");
			paramList.add(userModel.getEmail());
		} 
		
		if(!Util.isNull(userModel.getUpdateUser())) {
			hql.append(" and u.updateUser = ?");
			paramList.add(userModel.getUpdateUser());
		}
		if(!Util.isNull(userModel.getCreateUser())){
			hql.append(" and u.createUser = ?");
			paramList.add(userModel.getCreateUser());
		} 
		if (userModel.getSex() != null) {
			hql.append(" and u.sex = ?");
			paramList.add(userModel.getSex());
		}
		hql.append(" order by u.createTime desc");
		
		Long totalRow = userDao.count(hql.toString(), paramList); 
		
		Page pages = new Page(totalRow.intValue(), pageSize, page);
		//这里用到了Page类中的获取首页和分页大小的方法
		List<User> list = userDao.find(hql.toString(), paramList, page, pageSize);

		//把取出来的结果放到list中
		PageResultSet<User> pageResultSet = new PageResultSet<User>();

		pageResultSet.setList(list);

		pageResultSet.setPage(pages);

		return pageResultSet;
	}

}