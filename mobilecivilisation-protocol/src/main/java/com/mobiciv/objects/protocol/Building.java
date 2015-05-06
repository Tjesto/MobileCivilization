package com.mobiciv.objects.protocol;

public class Building implements java.io.Serializable{
	private String cityName;
	private BuildingType buildingType;
	
	Building( String cityName, BuildingType buildingType ){
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
