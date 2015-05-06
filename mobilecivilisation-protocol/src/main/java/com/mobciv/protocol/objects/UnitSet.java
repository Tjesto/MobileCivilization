package com.mobciv.protocol.objects;

import java.util.HashSet;
import java.util.Set;

import com.mobciv.datamodel.JsonSerializable;

public class UnitSet implements JsonSerializable{
	private Set<Unit> unitSet;

	UnitSet(Set<Unit> unitSet)
	{
		this.setUnitSet(unitSet);
	}
	
	public UnitSet() {
		this.setUnitSet(new HashSet<Unit>());
	}

	public Set<Unit> getUnitSet() {
		return unitSet;
	}

	public void setUnitSet(Set<Unit> unitSet) {
		this.unitSet = unitSet;
	}
}
