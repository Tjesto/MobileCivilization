package com.mobiciv.objects.protocol;

import java.util.HashSet;
import java.util.Set;

public class UnitSet implements java.io.Serializable{
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
