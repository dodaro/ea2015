package com.emon.onlinestore.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineStore {

	private Map<Integer, Item> items;
	
	public OnlineStore() {
		items = new HashMap<Integer, Item>();
		
		items.put(0, new Item(0, "RAM", 29.99));
		items.put(1, new Item(1, "Mouse", 9.99));
		items.put(2, new Item(2, "Keyboard", 13.99));
		items.put(3, new Item(3, "Monitor", 249.99));
		items.put(4, new Item(4, "CPU", 299.99));
		items.put(5, new Item(5, "Case", 39.99));
		items.put(6, new Item(6, "Video Card", 199.99));
		items.put(7, new Item(7, "Sound Card", 159.99));
		items.put(8, new Item(8, "Printer", 39.99));
		items.put(9, new Item(9, "Usb Hub", 19.99));
		items.put(10, new Item(10, "Hard Disk", 99.99));
		items.put(11, new Item(11, "Power Supply", 59.99));
		items.put(12, new Item(12, "Mother Board", 129.99));
		items.put(13, new Item(13, "Cooling fan", 29.99));
		items.put(14, new Item(14, "Network Card", 19.99));
		items.put(15, new Item(15, "DVD Drive", 39.99));
	}
	
	public List<Item> getItems() {
		return new ArrayList<Item>(items.values());
	}
	
	public Item getItemById(int id) {
		return items.get(id);
	}
}
