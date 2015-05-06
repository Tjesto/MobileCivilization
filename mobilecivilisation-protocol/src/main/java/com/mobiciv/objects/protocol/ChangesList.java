package com.mobiciv.objects.protocol;

public class ChangesList {
	private CitiesSet citiesCreated;
	private CitiesSet citiesDestroyed;
	private ItemsSet itemsConstructed;
	private ItemsSet itemsDestroyed;
	private DilomaticPropositionSet propositionsDiplomatic;
	private BuildingSet buildingStarted;
	private BuildingSet buildingFinished;
	private SpyingInfoSet spyingInfo;
	
	
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
	

}
