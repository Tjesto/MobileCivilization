package com.mobilecivilisation.units;

public interface IUnit {
	String getType();
	int getCost();
	int getDefense();
	int getAttack();
	int getProductivityCost();/*koszt w tarczach*/
	int getMovementPoints();
	int getMaxHealth();
}
