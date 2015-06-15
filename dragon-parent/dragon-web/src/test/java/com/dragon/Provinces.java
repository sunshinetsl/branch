package com.dragon;

import java.util.ArrayList;
import java.util.List;

public class Provinces {

	private String ID;
	
	private String ProvinceName;

	private List<City> citylist = new ArrayList<>();
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getProvinceName() {
		return ProvinceName;
	}

	public void setProvinceName(String provinceName) {
		ProvinceName = provinceName;
	}

	public List<City> getCitylist() {
		return citylist;
	}

	public void setCitylist(List<City> citylist) {
		this.citylist = citylist;
	}
	
	
}
