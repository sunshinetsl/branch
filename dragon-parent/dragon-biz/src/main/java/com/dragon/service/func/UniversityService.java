package com.dragon.service.func;

import org.springframework.stereotype.Service;

import com.dragon.entity.University;

@Service("universityService")
public interface UniversityService {

	public long insertUniversity(University university);
}
