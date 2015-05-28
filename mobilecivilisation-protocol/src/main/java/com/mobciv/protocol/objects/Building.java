package com.mobciv.protocol.objects;

import com.mobciv.datamodel.JsonSerializable;

public class Building implements JsonSerializable{
	private String cityName;
	private BuildingType buildingType;
	
	public Building( String cityName, BuildingType buildingType ){
		this.setBuildingType(buildingType);
		this.setCityName(cityName);
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
	}

}
