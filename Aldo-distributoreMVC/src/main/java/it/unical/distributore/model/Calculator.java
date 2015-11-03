package it.unical.distributore.model;

import java.util.ArrayList;

public class Calculator {

	private ArrayList<Double> numbers;
	
	public Calculator() {
		numbers = new ArrayList<Double>();
	}
	
	public void add(double number){
		
		numbers.add(number);
	}

	public double sum() {
		
		double sum = 0;
		for (Double number : numbers) {
			
			sum += number;
		}
		
		return sum;
	}
}
