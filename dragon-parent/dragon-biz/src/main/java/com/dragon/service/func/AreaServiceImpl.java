package com.dragon.service.func;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.dao.func.AreaDAO;
import com.dragon.entity.Area;

@Service("areaServiceImpl")
public class AreaServiceImpl<T> implements AreaService {

	private Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);

	@Autowired
	private AreaDAO<T> areaDAO;
	
	/**
	 * 新增
	 */
	@Override
	public Long insertArea(Area area) {
		if(logger.isDebugEnabled()){
			logger.debug("insertArea (area = {}) -->start",area);
		}
		long count = areaDAO.insertArea(area);
		return count;
	}
}
