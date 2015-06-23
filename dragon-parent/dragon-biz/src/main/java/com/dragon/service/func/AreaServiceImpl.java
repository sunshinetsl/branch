package com.dragon.service.func;

import com.dragon.common.util.FunctionConstants;
import com.dragon.entity.HomeImpress;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.dao.func.AreaDAO;
import com.dragon.entity.Area;

import java.util.Date;
import java.util.List;

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

	@Override
	public List<Area> queryByAllProvince(String oftenStatusActive) {
		if(logger.isDebugEnabled()){
			logger.debug("queryByAllProvince (oftenStatusActive = {}) -->start",oftenStatusActive);
		}
		if(StringUtils.isBlank(oftenStatusActive)){
			throw new IllegalArgumentException("参数不能为空！");
		}
		List<Area> areaList = areaDAO.queryByAllProvince(oftenStatusActive);
		return areaList;
	}

	/**
	 * 根据省查询市
	 * @param province
	 * @param oftenStatusActive
	 * @return
	 */
	@Override
	public List<Area> getCityByProvince(String province, String oftenStatusActive) {
		if(logger.isDebugEnabled()){
			logger.debug("getCityByProvince (province = {} oftenStatusActive = {})",province,oftenStatusActive);
		}
		if(StringUtils.isBlank(province) || StringUtils.isBlank(oftenStatusActive)){
			throw new IllegalArgumentException("参数不能为空！");
		}
		List<Area> areaList = areaDAO.getCityByProvince(province,oftenStatusActive);
		return areaList;
	}

	/**
	 * 查询区
	 * @param province
	 * @param city
	 * @param oftenStatusActive
	 * @return
	 */
	@Override
	public List<Area> getDistrict(String province, String city, String oftenStatusActive) {
		if (logger.isDebugEnabled()){
			logger.debug("getDistrict -->start");
		}
		if(StringUtils.isBlank(province) || StringUtils.isBlank(city) || StringUtils.isBlank(oftenStatusActive)){
			throw new IllegalArgumentException("参数不能为空");
		}
		List<Area> areaList = areaDAO.getDistrict(province, city, oftenStatusActive);
		return areaList;
	}

	/**
	 * 根据ID查询市
	 * @param provinceId
	 * @return
	 */
	@Override
	public List<Area> getCityByProvinceId(Integer provinceId) {
		if(logger.isDebugEnabled()){
			logger.debug("saveHomeImpress (provinceId = {})", provinceId);
		}
		if(null == provinceId){
			throw new IllegalArgumentException("参数不能为空");
		}
		List<Area> areaList = areaDAO.getCityByProvinceId(provinceId);
		return areaList;
	}

	/**
	 * 根据ID查询
	 * @param areaId
	 * @return
	 */
	@Override
	public Area queryAreaById(String areaId) {
		if(StringUtils.isBlank(areaId)){
			throw new IllegalArgumentException("参数不能为空");
		}
		Area area = areaDAO.queryAreaById(areaId);
		return null;
	}
}
