package com.dragon.entity;

// Generated 2015-6-4 14:41:35 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TUniversity generated by hbm2java
 */
@Entity
@Table(name = "t_university", catalog = "dragon")
public class University implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3562666494829286004L;
	private Integer id;
	private String universityName;
	private String collegeName;
	private String department;
	private Integer areaId;

	public University() {
	}

	public University(String universityName, String collegeName,
			String department, Integer areaId) {
		this.universityName = universityName;
		this.collegeName = collegeName;
		this.department = department;
		this.areaId = areaId;
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

	@Column(name = "university_name", length = 45)
	public String getUniversityName() {
		return this.universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Column(name = "college_name", length = 45)
	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Column(name = "department", length = 45)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "area_id")
	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

}
