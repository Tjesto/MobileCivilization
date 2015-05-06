package com.mobciv.protocol.objects;

import java.util.HashSet;
import java.util.Set;

import com.mobciv.datamodel.JsonSerializable;

public class BuildingSet implements JsonSerializable {
	private Set<Building> buildings;

	BuildingSet( Set<Building> buildings ){
		this.setBuildings(buildings);
	}

	public BuildingSet() {
		this.setBuildings(new HashSet<Building>());
	}

	public Set<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(Set<Building> buildings) {
		this.buildings = buildings;
	}
}
