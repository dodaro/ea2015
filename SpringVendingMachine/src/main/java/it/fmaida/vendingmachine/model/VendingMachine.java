package it.fmaida.vendingmachine.model;

public class VendingMachine {

	private final Item coffeeItem = new Item("Coffee", 1);
	private final Item waterItem = new Item("Water", 1);
	private final Item teaItem = new Item("Tea", 2);
	private final Item juiceItem = new Item("Juice", 3);
	private final Item vodkaItem = new Item("Vodka", 7);
	private final Item beerItem = new Item("Beer", 5);
	
	
	public VendingMachine() {
		// TODO Auto-generated constructor stub
	}


	public Item getCoffeeItem() {
		return coffeeItem;
	}


	public Item getWaterItem() {
		return waterItem;
	}


	public Item getTeaItem() {
		return teaItem;
	}


	public Item getJuiceItem() {
		return juiceItem;
	}


	public Item getVodkaItem() {
		return vodkaItem;
	}


	public Item getBeerItem() {
		return beerItem;
	}
	
	
	
	
	
}
