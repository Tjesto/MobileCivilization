package com.mobiciv.objects.protocol;

import java.util.HashSet;
import java.util.Set;

public class UnitHealthChangeSet implements java.io.Serializable{
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
