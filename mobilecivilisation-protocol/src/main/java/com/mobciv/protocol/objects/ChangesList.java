package com.mobciv.protocol.objects;

import com.mobciv.datamodel.JsonSerializable;

public class ChangesList implements JsonSerializable {
	private CitiesSet citiesCreated;
	private CitiesSet citiesDestroyed;
	private ItemsSet itemsConstructed;
	private ItemsSet itemsDestroyed;
	private DilomaticPropositionSet propositionsDiplomatic;
	private BuildingSet buildingStarted;
	private BuildingSet buildingFinished;
	private SpyingInfoSet spyingInfo;
	private UnitSet unitsCreated;
	private UnitSet unitsMoved;
	private UnitHealthChangeSet unitsHealthChange;
	private UnitSet unitsDestroyed;

	ChangesList(CitiesSet citiesCreated, CitiesSet citiesDestroyed,
			ItemsSet itemsConstructed, ItemsSet itemsDestroyed,
			DilomaticPropositionSet propositionsDiplomatic,
			BuildingSet buildingStarted, BuildingSet buildingFinished,
			SpyingInfoSet spyingInfo, UnitSet unitsCreated, UnitSet unitsMoved,
			UnitHealthChangeSet unitsHealthChange, UnitSet unitsDestroyed) {
		this.setCitiesCreated(citiesCreated);
		this.setCitiesDestroyed(citiesDestroyed);
		this.setItemsConstructed(itemsConstructed);
		this.setItemsDestroyed(itemsDestroyed);
		this.setPropositionsDiplomatic(propositionsDiplomatic);
		this.setBuildingStarted(buildingStarted);
		this.setBuildingFinished(buildingFinished);
		this.setSpyingInfo(spyingInfo);
		this.setUnitsCreated(unitsCreated);
		this.setUnitsMoved(unitsMoved);
		this.setUnitsHealthChange(unitsHealthChange);
		this.setUnitsMoved(unitsDestroyed);
	}

	ChangesList() {
		this.setCitiesCreated(new CitiesSet());
		this.setCitiesDestroyed(new CitiesSet());
		this.setItemsConstructed(new ItemsSet());
		this.setItemsDestroyed(new ItemsSet());
		this.setPropositionsDiplomatic(new DilomaticPropositionSet());
		this.setBuildingStarted(new BuildingSet());
		this.setBuildingFinished(new BuildingSet());
		this.setSpyingInfo(new SpyingInfoSet());
		this.setUnitsCreated(new UnitSet());
		this.setUnitsMoved(new UnitSet());
		this.setUnitsHealthChange(new UnitHealthChangeSet());
		this.setUnitsMoved(new UnitSet());
	}

	public CitiesSet getCitiesCreated() {
		return citiesCreated;
	}

	public void setCitiesCreated(CitiesSet citiesCreated) {
		this.citiesCreated = citiesCreated;
	}

	public CitiesSet getCitiesDestroyed() {
		return citiesDestroyed;
	}

	public void setCitiesDestroyed(CitiesSet citiesDestroyed) {
		this.citiesDestroyed = citiesDestroyed;
	}

	public ItemsSet getItemsConstructed() {
		return itemsConstructed;
	}

	public void setItemsConstructed(ItemsSet itemsConstructed) {
		this.itemsConstructed = itemsConstructed;
	}

	public ItemsSet getItemsDestroyed() {
		return itemsDestroyed;
	}

	public void setItemsDestroyed(ItemsSet itemsDestroyed) {
		this.itemsDestroyed = itemsDestroyed;
	}

	public DilomaticPropositionSet getPropositionsDiplomatic() {
		return propositionsDiplomatic;
	}

	public void setPropositionsDiplomatic(
			DilomaticPropositionSet propositionsDiplomatic) {
		this.propositionsDiplomatic = propositionsDiplomatic;
	}

	public BuildingSet getBuildingFinished() {
		return buildingFinished;
	}

	public void setBuildingFinished(BuildingSet buildingFinished) {
		this.buildingFinished = buildingFinished;
	}

	public SpyingInfoSet getSpyingInfo() {
		return spyingInfo;
	}

	public void setSpyingInfo(SpyingInfoSet spyingInfo) {
		this.spyingInfo = spyingInfo;
	}

	public BuildingSet getBuildingStarted() {
		return buildingStarted;
	}

	public void setBuildingStarted(BuildingSet buildingStarted) {
		this.buildingStarted = buildingStarted;
	}

	public UnitSet getUnitsMoved() {
		return unitsMoved;
	}

	public void setUnitsMoved(UnitSet unitsMoved) {
		this.unitsMoved = unitsMoved;
	}

	public UnitSet getUnitsDestroyed() {
		return unitsDestroyed;
	}

	public void setUnitsDestroyed(UnitSet unitsDestroyed) {
		this.unitsDestroyed = unitsDestroyed;
	}

	public UnitSet getUnitsCreated() {
		return unitsCreated;
	}

	public void setUnitsCreated(UnitSet unitsCreated) {
		this.unitsCreated = unitsCreated;
	}

	public UnitHealthChangeSet getUnitsHealthChange() {
		return unitsHealthChange;
	}

	public void setUnitsHealthChange(UnitHealthChangeSet unitsHealthChange) {
		this.unitsHealthChange = unitsHealthChange;
	}

}
