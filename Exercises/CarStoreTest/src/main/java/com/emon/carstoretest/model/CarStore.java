package com.emon.carstoretest.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarStore {
	
	private Map<String, Double> modelsAndPrices;
	private Map<String, Double> colorsAndPrices;

	public CarStore() {
		this.modelsAndPrices = new HashMap<String, Double>();
		modelsAndPrices.put("Ferrari", 120000.00);
		modelsAndPrices.put("Lamborghini", 110000.00);
		modelsAndPrices.put("Porsche", 90000.00);
		
		this.colorsAndPrices = new HashMap<String, Double>();
		colorsAndPrices.put("red", 100.00);
		colorsAndPrices.put("yellow", 200.00);
		colorsAndPrices.put("blue", 300.00);
	}
	
	public List<String> getModels() {
		return new ArrayList<String>(modelsAndPrices.keySet());
	}
	
	public Double getModelPrice(String model) {
		return modelsAndPrices.get(model);
	}
	
	public Double getColorPrice(String color) {
		return colorsAndPrices.get(color);
	}
	
	public List<String> getColors() {
		return new ArrayList<String>(colorsAndPrices.keySet());
	}
}
