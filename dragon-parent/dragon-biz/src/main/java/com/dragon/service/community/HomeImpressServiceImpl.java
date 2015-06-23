package com.dragon.service.community;

import com.dragon.common.util.FunctionConstants;
import com.dragon.entity.HomeImpress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.dao.community.HomeImpressDAO;

import java.util.Date;

@Service("homeImpressServiceImpl")
public class HomeImpressServiceImpl<T> implements HomeImpressService{

	@Autowired
	private HomeImpressDAO<T> homeImpressDAO;
	
	private Logger logger = LoggerFactory.getLogger(HomeImpressServiceImpl.class);


	/**
	 * 保存发布的印象信息
	 * @param homeImpress
	 * @return
	 */
	@Override
	public int saveHomeImpress(HomeImpress homeImpress) {
		if(logger.isDebugEnabled()){
			logger.debug("saveHomeImpress (homeImpress = {})", homeImpress);
		}
		if(null == homeImpress){
			throw new IllegalArgumentException("参数不能为空");
		}
		homeImpress.setCreateTime(new Date());
		homeImpress.setUpdateTime(new Date());
		homeImpress.setStatusCode(FunctionConstants.OFTEN_STATUS_ACTIVE);
		int count = homeImpressDAO.saveHomeImpress(homeImpress);
		logger.debug("saveHomeImpress count={}",count);
		return count;
	}
}
