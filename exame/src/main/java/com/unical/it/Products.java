package com.unical.it;

public class Products {


public static Integer getPrice(String product) {
	if(product.equals("Dark_tinted rear windows"))
		return 1;
	else if(product.equals(" Electrically adjustable/heated door mirrors"))
		return 2;
	else if(product.equals("Electrically operate front wondow"))
		return 10;
	
	else if(product.equals("Removable luggage compartment cover"))
		return 20;
	
	return 0;
}
}