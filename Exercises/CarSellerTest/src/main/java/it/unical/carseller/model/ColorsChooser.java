package it.unical.carseller.model;

import java.util.HashMap;
import java.util.Map;

public class ColorsChooser {
	
	private Map<Integer, Color> colorMap = new HashMap<Integer, Color>();
	private Integer myColor;
	
	public Map<Integer, Color> getColorMap() {
		return colorMap;
	}
	
	public void setColorMap(Map<Integer, Color> colorMap) {
		this.colorMap = colorMap;
	}
	
	public Integer getMyColor() {
		return myColor;
	}
	
	public void setMyColor(Integer myColor) {
		this.myColor = myColor;
	}

	
	
	
}
