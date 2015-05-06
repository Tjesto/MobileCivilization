package com.mobciv.protocol.objects;

import java.util.HashSet;
import java.util.Set;

import com.mobciv.datamodel.JsonSerializable;

public class CitiesSet implements JsonSerializable {
	private Set<City> cities;

	CitiesSet( Set<City> cities ){
		this.setCities(cities);
	}
	
	public CitiesSet() {
		this.setCities(new HashSet<City>());
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
}
