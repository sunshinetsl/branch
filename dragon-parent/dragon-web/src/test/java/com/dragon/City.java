package com.dragon;

import java.util.ArrayList;
import java.util.List;

public class City {

	//<City ID="72" CityName="大兴安岭地区" PID="8" ZipCode="165000">大兴安岭地区</City>
	
	private String ID;
	
	private String CityName;
	
	private String PID;
	
	private List<Districts> dicList = new ArrayList<>();

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getPID() {
		return PID;
	}

	public void setPID(String pID) {
		PID = pID;
	}

	public List<Districts> getDicList() {
		return dicList;
	}

	public void setDicList(List<Districts> dicList) {
		this.dicList = dicList;
	}
	
	
	
}
