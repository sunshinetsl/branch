package com.dragon.service.func;

import org.springframework.stereotype.Service;

import com.dragon.entity.Area;

@Service("areaService")
public interface AreaService {

	public Long insertArea(Area area);
}
