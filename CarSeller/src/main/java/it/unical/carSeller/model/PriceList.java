package it.unical.carSeller.model;

public class PriceList {
 
	
	public static int getPrice(String name){
		if(name.equals("SE")){
			return 15000;
		}
		else if(name.equals("SL")){
			return 12400;
		}
		else if(name.equals("SEA")){
			return 11000;
		}
		return 0;
	}
	
	public static int getColorPrice(String color) {
		if(color.equals("RED")){
			return 300;
		}
		else if(color.equals("BLUE")){
			return 500;
		}
		else if(color.equals("GREEN")){
			return 450;
		}
		return 0;
	}
}
