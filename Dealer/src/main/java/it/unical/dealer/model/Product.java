package it.unical.dealer.model;

public class Product {

	String name;
	int price;

	public Product() {

	}

	public Product(String n, int p) {
		name = n;
		price = p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return new String(name+" "+price);
	}

}
