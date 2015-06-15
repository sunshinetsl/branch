package com.dragon.service.community;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.dao.community.HomeImpressDAO;

@Service("homeImpressServiceImpl")
public class HomeImpressServiceImpl<T> implements HomeImpressService{

	@Autowired
	private HomeImpressDAO<T> homeImpressDAO;
	
	private Logger logger = LoggerFactory.getLogger(HomeImpressServiceImpl.class);
}
