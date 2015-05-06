package com.mobciv.protocol.objects;

import com.mobciv.datamodel.JsonSerializable;

public class Item implements JsonSerializable{
	private Coordinates coordinates;
	private ItemType itemType;
	
	Item(Coordinates coordinates, ItemType itemType){
		this.setCoordinates(coordinates);
		this.setItemType(itemType);
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
}
