package com.mobiciv.objects.protocol;

import java.util.Set;

public class CitiesSet {
	private Set<City> cities;

	CitiesSet( Set<City> cities ){
		this.setCities(cities);
	}
	
	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
}
