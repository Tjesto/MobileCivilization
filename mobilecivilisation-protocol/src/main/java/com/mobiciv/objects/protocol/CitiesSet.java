package com.mobiciv.objects.protocol;

import java.util.HashSet;
import java.util.Set;

public class CitiesSet implements java.io.Serializable{
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
