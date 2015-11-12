package it.fmaida.model;


public class SimpleCar implements CarInterface {

	private String label;
	private String name;
	private int price;
	
	public SimpleCar() {
	}
	
	@Override
	public String getLabel() {
		return this.label;
	}
	
	@Override
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public int getPrice() {
		return this.price;
	}
	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	

	
	
}
