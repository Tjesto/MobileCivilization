package com.mobiciv.objects.protocol;

import java.util.HashSet;
import java.util.Set;

public class ItemsSet implements java.io.Serializable{
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
