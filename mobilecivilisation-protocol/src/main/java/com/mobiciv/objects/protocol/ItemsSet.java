package com.mobiciv.objects.protocol;

import java.util.Set;

public class ItemsSet {
	private Set<Item> items;

	ItemsSet( Set<Item> items ){
		this.setItems(items);
	}
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

}
