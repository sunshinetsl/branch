package com.dragon.dao.func;

import org.springframework.stereotype.Repository;

import com.dragon.common.dao.BaseDAO;
import com.dragon.entity.Area;

/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
@Repository
public class AreaDAO<T> extends BaseDAO<T>{

	/**
	 * 新增
	 * @param area
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public long insertArea(Area area) {
		long count = 0;
		try {
			count = super.save((T) area);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
