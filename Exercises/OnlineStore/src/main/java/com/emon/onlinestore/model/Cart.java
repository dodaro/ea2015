package com.emon.onlinestore.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

	/* Cart is saved as a map of items and quantity. */
	private Map<Item, Integer> items;

	public Cart() {
		items = new HashMap<Item, Integer>();
	}

	public List<Item> getItems() {
		return new ArrayList<Item>(items.keySet());
	}

	public void addItem(Item item, int quantity) {
		items.put(item, quantity);
	}
	
	public boolean contains(Item item) {
		return items.containsKey(item);
	}
}
