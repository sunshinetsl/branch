package com.dragon.entity;

// Generated 2015-6-4 14:41:35 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TSysParameter generated by hbm2java
 */
@Entity
@Table(name = "t_sys_parameter", catalog = "dragon")
public class SysParameter implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String paramKey;
	private String paramValue;
	private String description;
	private String createTime;
	private String updateTime;

	public SysParameter() {
	}

	public SysParameter(String paramKey, String paramValue,
			String description, String createTime, String updateTime) {
		this.paramKey = paramKey;
		this.paramValue = paramValue;
		this.description = description;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "param_key", length = 45)
	public String getParamKey() {
		return this.paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	@Column(name = "param_value", length = 45)
	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "create_time", length = 45)
	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 45)
	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
