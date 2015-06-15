package com.dragon.service.func;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.dao.func.UniversityDAO;
import com.dragon.entity.University;

@Service("universityServiceImpl")
public class UniversityServiceImpl<T> implements UniversityService {

	private Logger logger = LoggerFactory.getLogger(UniversityServiceImpl.class);
	
	@Autowired
	private UniversityDAO<T> universityDAO;

	@Override
	public long insertUniversity(University university) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertUniversity (university = {})", university);
		}
		long count = 0;
		try {
			count = universityDAO.save((T) university);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
