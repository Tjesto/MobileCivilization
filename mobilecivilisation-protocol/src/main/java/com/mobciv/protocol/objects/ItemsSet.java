package com.mobciv.protocol.objects;

import java.util.HashSet;
import java.util.Set;

import com.mobciv.datamodel.JsonSerializable;

public class ItemsSet implements JsonSerializable{
	private Set<Item> items;

	ItemsSet( Set<Item> items ){
		this.setItems(items);
	}
	public ItemsSet() {
		this.setItems(new HashSet<Item>());
	}
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

}
