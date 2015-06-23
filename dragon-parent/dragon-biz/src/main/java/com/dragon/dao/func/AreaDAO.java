package com.dragon.dao.func;

import com.dragon.common.util.FunctionConstants;
import com.dragon.entity.HomeImpress;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.dragon.common.dao.BaseDAO;
import com.dragon.entity.Area;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
@Repository
public class AreaDAO<T> extends BaseDAO<T>{

	/**
	 * 新增
	 * @param area
	 * @return
	 */
	public long insertArea(Area area) {
		long count = 0;
		try {
			count = super.save((T) area);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 查询所有省
	 * @param statusActive
	 * @return
	 */
	public List<Area> queryByAllProvince(String statusActive) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from Area a where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotBlank(statusActive)){
			buffer.append(" and a.statusCode = ?");
			params.add(statusActive);
		}
		buffer.append(" group by a.province order by a.id");
		String hql = buffer.toString();
		List<Area> areaList = (List<Area>) super.find(hql,params);
		return areaList;
	}

	/**
	 * 根据省查询市
	 * @param province
	 * @param oftenStatusActive
	 * @return
	 */
	public List<Area> getCityByProvince(String province, String oftenStatusActive) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from  Area a where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotBlank(province)){
			buffer.append(" and a.province = ?");
			params.add(province);
		}
		if(StringUtils.isNotBlank(oftenStatusActive)){
			buffer.append(" and a.statusCode = ?");
			params.add(oftenStatusActive);
		}
		buffer.append(" group by a.city ");
		buffer.append(" order by a.id");
		String hql = buffer.toString();
		List<Area> areaList = (List<Area>) super.find(hql,params);
		return areaList;
	}

	/**
	 * 查询区
	 * @param province
	 * @param city
	 * @param oftenStatusActive
	 * @return
	 */
	public List<Area> getDistrict(String province, String city, String oftenStatusActive) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from  Area a where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotBlank(province)){
			buffer.append(" and a.province = ?");
			params.add(province);
		}
		if(StringUtils.isNotBlank(city)){
			buffer.append(" and a.city = ?");
			params.add(city);
		}
		if(StringUtils.isNotBlank(oftenStatusActive)){
			buffer.append(" and a.statusCode = ?");
			params.add(oftenStatusActive);
		}
		buffer.append(" order by a.id");
		String hql = buffer.toString();
		List<Area> areaList = (List<Area>) super.find(hql,params);
		return areaList;
	}

	/**
	 * 根据ID查询市
	 * @param provinceId
	 * @return
	 */
	public List<Area> getCityByProvinceId(Integer provinceId) {
		StringBuffer buffer = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		buffer.append("from Area a where 1=1 ");
		if(null != provinceId && 0 != provinceId){
			buffer.append(" and id = ?");
			params.add(provinceId);
		}
		buffer.append(" and a.statusCode = ?");
		params.add(FunctionConstants.OFTEN_STATUS_ACTIVE);
		String hql = buffer.toString();
		List<Area> areaList = (List<Area>) super.find(hql,params);
		return areaList;
	}

	/**
	 * 根据ID查询
	 * @param areaId
	 * @return
	 */
	public Area queryAreaById(String areaId) {
		Area area = (Area) super.get((Class<T>) Area.class, areaId);
		return area;
	}
}
