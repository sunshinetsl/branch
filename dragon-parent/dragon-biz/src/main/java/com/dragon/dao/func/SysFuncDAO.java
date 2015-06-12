package com.dragon.dao.func;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.dragon.common.dao.BaseDAO;
import com.dragon.entity.SysFunc;

@Repository
public class SysFuncDAO<T> extends BaseDAO<T>{

	/**
	 * 去节点
	 */
	@SuppressWarnings("unchecked")
	public List<SysFunc> ajaxGetFunctionMenu(String functionMenuType,
			String oftenStatusActive) {
		StringBuilder builder = new StringBuilder();
		builder.append("from SysFunc s where id != 1 ");
		if(StringUtils.isNotBlank(functionMenuType)){
			builder.append(" and s.funcType = '").append(functionMenuType).append("'");
		}
		if(StringUtils.isNotBlank(oftenStatusActive)){
			builder.append(" and s.statusCode = '").append(oftenStatusActive).append("'");
		}
		builder.append(" order by s.displaySequence");
		String hql = builder.toString();
		List<SysFunc> funList = (List<SysFunc>) super.find(hql);
		return funList;
	}
	
}
