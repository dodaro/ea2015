package it.unical.coffee.model;

public class Product {

	public static Integer getPrice(String product) {
		if(product.equals("Coffee"))
			return 1;
		else if(product.equals("Milk"))
			return 2;
		else if(product.equals("Vodka"))
			return 10;
		
		return 0;
	}
}
