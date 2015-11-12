package it.unical.cartest.model;

import java.util.HashMap;

public class ColorManager {

	private HashMap<Integer, Color> colors;
	
	public ColorManager() {

		this.colors = new HashMap<Integer, Color>();
		initColors();
	}
	
	private void initColors() {
		
		Color c1 = new Color("red", 100);
		Color c2 = new Color("green", 150);
		Color c3 = new Color("blue", 50);
		
		this.colors.put(c1.getId(), c1);
		this.colors.put(c2.getId(), c2);
		this.colors.put(c3.getId(), c3);
		
	}

	public HashMap<Integer, Color> getColors() {
		return colors;
	}

	public void setColors(HashMap<Integer, Color> colors) {
		this.colors = colors;
	}
	
}
