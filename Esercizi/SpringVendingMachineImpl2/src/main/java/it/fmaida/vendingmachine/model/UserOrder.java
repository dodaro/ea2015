package it.fmaida.vendingmachine.model;

import java.util.ArrayList;

public class UserOrder {
	
	ArrayList<Integer> selectedItems;
	
	public UserOrder() {
		this.selectedItems = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getSelectedItems() {
		return selectedItems;
	}
	
	public void setSelectedItems(ArrayList<Integer> selectedItems) {
		this.selectedItems = selectedItems;
	}
	
}
