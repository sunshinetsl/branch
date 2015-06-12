package com.dragon.service.func;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.common.util.CustomException;
import com.dragon.dao.func.SysDictDAO;
import com.dragon.entity.SysDict;

@Service("sysDictserviceImpl")
public class SysDictserviceImpl<T> implements SysDictService {

	private Logger logger = LoggerFactory.getLogger(SysDictserviceImpl.class);
	
	@Autowired
	private SysDictDAO<T> sysDictDAO;

	/**
	 * 根据字典code查询
	 */
	@Override
	public List<SysDict> queryByCode(String dictCode) {
		if(logger.isDebugEnabled()){
			logger.debug("queryByCode (dictCode = {}) -->start",dictCode);
		}
		if(StringUtils.isBlank(dictCode)){
			try {
				throw new CustomException("字典code不能为空");
			} catch (CustomException e) {
				logger.debug("queryByCode {}", e.getMessage());
				e.printStackTrace();
			}
		}
		List<SysDict> dictList = sysDictDAO.queryByCode(dictCode);
		logger.debug("queryByCode (dictList = {}) -->end", dictList);
		return dictList;
	}

	/**
	 * 根据字典code和分类code查询
	 */
	@Override
	public SysDict queryByCodeAndItem(String dictCode, String itemCode) {
		if(logger.isDebugEnabled()){
			logger.debug("queryByCodeAndItem (dictCode = {} itemCode = {})", dictCode, itemCode);
		}
		if(StringUtils.isBlank(dictCode) || StringUtils.isBlank(itemCode)){
			try {
				throw new CustomException("参数不能为空");
			} catch (CustomException e) {
				logger.debug("queryByCodeAndItem {}", e.getMessage());
				e.printStackTrace();
			}
		}
		SysDict sysDict = sysDictDAO.queryByCodeAndItem(dictCode,itemCode);
		logger.debug("queryByCodeAndItem {}",sysDict);
		return sysDict;
	}

	/**
	 * 根据ID查询
	 */
	@Override
	public SysDict queryById(Integer id) {
		if(logger.isDebugEnabled()){
			logger.debug("queryById (id = {})", id);
		}
		if(null == id || 0 == id){
			try {
				throw new CustomException("参数不能为空");
			} catch (CustomException e) {
				logger.debug("queryByCodeAndItem {}", e.getMessage());
				e.printStackTrace();
			}
		}
		SysDict sysDict = sysDictDAO.queryById(id);
		return sysDict;
	}
}
