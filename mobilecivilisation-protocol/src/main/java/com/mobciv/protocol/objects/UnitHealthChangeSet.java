package com.mobciv.protocol.objects;

import java.util.HashSet;
import java.util.Set;

import com.mobciv.datamodel.JsonSerializable;

public class UnitHealthChangeSet implements JsonSerializable{
	private Set<UnitHealthChange> unitHealthChangeSet;

	UnitHealthChangeSet(Set<UnitHealthChange> unitHealthChangeSet)
	{
		this.setUnitHealthChangeSet(unitHealthChangeSet);
	}
	

	public UnitHealthChangeSet() {
		super();
		this.setUnitHealthChangeSet(new HashSet<UnitHealthChange>());
	}


	public Set<UnitHealthChange> getUnitHealthChangeSet() {
		return unitHealthChangeSet;
	}

	public void setUnitHealthChangeSet(Set<UnitHealthChange> unitHealthChangeSet) {
		this.unitHealthChangeSet = unitHealthChangeSet;
	}
}
