package com.dragon.service.func;

import org.springframework.stereotype.Service;

import com.dragon.entity.Area;

import java.util.List;

@Service("areaService")
public interface AreaService {

	Long insertArea(Area area);

	List<Area> queryByAllProvince(String oftenStatusActive);

	List<Area> getCityByProvince(String province, String oftenStatusActive);

	List<Area> getDistrict(String province, String city, String oftenStatusActive);
}
