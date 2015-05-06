package com.mobiciv.objects.protocol;

import java.util.Set;

public class BuildingSet {
	private Set<Building> buildings;

	BuildingSet( Set<Building> buildings ){
		this.setBuildings(buildings);
	}

	public Set<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(Set<Building> buildings) {
		this.buildings = buildings;
	}
}
