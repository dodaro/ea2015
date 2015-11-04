package it.fmaida.vendingmachine.model;

import java.util.ArrayList;

public class VendingMachine {

	
	private ArrayList<Item> itemsList;
	

	public VendingMachine() {	
		this.itemsList = new ArrayList<Item>();
	}


	public ArrayList<Item> getItemsList() {
		return itemsList;
	}
	
	
	public void setItemsList(ArrayList<Item> itemsList) {
		this.itemsList = itemsList;
	}
	
}
