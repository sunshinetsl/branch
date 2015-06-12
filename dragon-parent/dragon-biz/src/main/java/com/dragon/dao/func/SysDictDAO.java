package com.dragon.dao.func;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.dragon.common.dao.BaseDAO;
import com.dragon.common.util.FunctionConstants;
import com.dragon.entity.SysDict;

/**
 * 字典DAO
 * @author Administrator
 *
 * @param <T>
 */
@Repository
public class SysDictDAO<T> extends BaseDAO<T>{

	private StringBuilder builder;
	
	/**
	 * 根据字典code查询
	 * 有排序
	 * @param dictCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SysDict> queryByCode(String dictCode) {
		builder = new StringBuilder();
		builder.append("from SysDict s where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotBlank(dictCode)){
			builder.append(" and s.dictCode = ?");
			params.add(dictCode);
		}
		builder.append(" and s.itemStatusCode = ?");
		params.add(FunctionConstants.OFTEN_STATUS_ACTIVE);
		builder.append(" order by s.displaySeq");
		String hql = builder.toString();
		List<SysDict> dictList = (List<SysDict>) super.find(hql, params);
		return dictList;
	}

	/**
	 * 根据字典code和分类code查询
	 * @param dictCode
	 * @param itemCode
	 * @return
	 */
	public SysDict queryByCodeAndItem(String dictCode, String itemCode) {
		builder = new StringBuilder();
		builder.append("from SysDict s where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotBlank(dictCode)){
			builder.append(" and s.dictCode = ?");
			params.add(dictCode);
		}
		if(StringUtils.isNotBlank(itemCode)){
			builder.append(" and s.itemCode = ?");
			params.add(itemCode);
		}
		String hql = builder.toString();
		SysDict sysDict = (SysDict) super.get(hql, params);
		return sysDict;
	}

	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	public SysDict queryById(Integer id) {
		builder = new StringBuilder();
		builder.append("from SysDict s where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(null != id && 0 != id){
			builder.append(" and s.id = ?");
			params.add(id);
		}
		String hql = builder.toString();
		SysDict sysDict = (SysDict) super.get(hql, params);
		return sysDict;
	}

}
