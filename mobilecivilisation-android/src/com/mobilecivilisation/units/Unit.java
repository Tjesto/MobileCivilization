package com.mobilecivilisation.units;
public class Unit implements IUnit {

	private int unitId;
	private int unitTypeId;
	private static final UnitsManager unitManager = UnitsManager.getInstance();

	Unit(int unitId, int unitTypeId) {
		this.setUnitId(unitId);
		this.setUnitTypeId(unitTypeId);
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public int getUnitTypeId() {
		return unitTypeId;
	}

	public void setUnitTypeId(int unitTypeId) {
		this.unitTypeId = unitTypeId;
	}

	@Override
	public String getType() {
		return unitManager.getType(this.unitTypeId);
	}

	@Override
	public int getCost() {
		return unitManager.getCost(this.unitTypeId);
	}

	@Override
	public int getDefense() {
		return unitManager.getDefense(this.unitTypeId);
	}

	@Override
	public int getAttack() {
		return unitManager.getAttack(this.unitTypeId);
	}

	@Override
	public int getProductivityCost() {
		return unitManager.getProductivityCost(this.unitTypeId);
	}

	@Override
	public int getMovementPoints() {
		return unitManager.getMovementPoints(this.unitTypeId);
	}

	@Override
	public int getMaxHealth() {
		return unitManager.getMaxHealth(this.unitTypeId);
	}
	
	
}
