package com.mobiciv.objects.protocol;

public class Item {
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
