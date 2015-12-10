package it.unical.carseller.model;

public class Car {
	
	private CarModel carModel;
	private Color color;
	private Double price;
	
	public Car() {
		carModel = new CarModel();
		color = new Color();
		price = 0.0;
	}

	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}	
}
