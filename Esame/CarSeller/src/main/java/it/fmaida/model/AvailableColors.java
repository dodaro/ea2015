package it.fmaida.model;

import java.util.ArrayList;

public class AvailableColors {

	private ArrayList<Color> colors;
	
	public AvailableColors() {
		
	}
	
	public ArrayList<Color> getColors() {
		return colors;
	}
	
	public void setColors(ArrayList<Color> colors) {
		this.colors = colors;
	}

	public Color findColorByName(String color) {
		for ( Color currentColor : colors ) {
			if ( currentColor.getName().equals(color) ) {
				return currentColor;
			}
		}
		return null;
	}
	
}
