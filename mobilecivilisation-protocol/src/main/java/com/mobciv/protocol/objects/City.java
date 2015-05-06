package com.mobciv.protocol.objects;

import com.mobciv.datamodel.JsonSerializable;


public class City implements JsonSerializable {
	
	private String name;
	private Coordinates coordinates;
	private int Size;
	
	City( String name, Coordinates cooridnates, int Size )
	{
		this.setName(name);
		this.setCoordinates(cooridnates);
		this.setSize(Size);
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
