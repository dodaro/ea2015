package it.unical.cars.model;

public class Product {

	public static Integer getPrice(String product) {
		if(product.equals("SE"))
			return 11000;
		else if(product.equals("SE A/L"))
			return 12400;
		else if(product.equals("SL"))
			return 15000;
		
		return 0;
	}
}
