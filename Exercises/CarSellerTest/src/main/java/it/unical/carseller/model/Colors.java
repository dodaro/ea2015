package it.unical.carseller.model;

public class Colors {

	public static Integer getPrice(String color) {
		if (color.equals("Blue"))
			return 100;
		else if (color.equals("Red"))
			return 200;
		else if (color.equals("Yellow"))
			return 300;

		return 0;
	}
}