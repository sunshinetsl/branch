package com.dragon.service.func;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.dao.func.SysFuncDAO;
import com.dragon.entity.SysFunc;

@Service("sysFuncServiceImpl")
public class SysFuncServiceImpl<T> implements SysFuncService {

	private Logger logger = LoggerFactory.getLogger(SysFuncServiceImpl.class);
	
	@Autowired
	private SysFuncDAO<T> sysFuncDAO;
	
	/**
	 * 取节点
	 */
	public List<SysFunc> ajaxGetFunctionMenu(String functionMenuType,
			String oftenStatusActive) {
		logger.debug("ajaxGetFunctionMenu functionMenuType={},oftenStatusActive={} -->start",functionMenuType,oftenStatusActive);
		List<SysFunc> funcList = sysFuncDAO.ajaxGetFunctionMenu(functionMenuType,oftenStatusActive);
		return funcList;
	}

}
