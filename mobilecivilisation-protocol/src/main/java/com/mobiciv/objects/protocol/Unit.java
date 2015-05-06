package com.mobiciv.objects.protocol;

public class Unit implements java.io.Serializable{
	/*There is no information about units health*/
	private Coordinates coordinates;
	private int ID;
	private UnitType unitType;
	
	Unit( Coordinates coordinates, int ID, UnitType unitType )
	{
		this.setCoordinates(coordinates);
		this.setID(ID);
		this.setUnitType(unitType);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
}
