package com.mobiciv.objects.protocol;

public class UnitHealthChange extends Unit {

	private int healthChange;
	UnitHealthChange(Coordinates coordinates, int ID, UnitType unitType, int healthChange) {
		super(coordinates, ID, unitType);
		this.setHealthChange(healthChange);
	}
	public int getHealthChange() {
		return healthChange;
	}
	public void setHealthChange(int healthChange) {
		this.healthChange = healthChange;
	}

}
