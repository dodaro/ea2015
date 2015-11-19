package it.unical.carseller.model;

public class Response {
	String modelChoosed;
	String colorChoosed;
	double priceChoosed;
	
	
	public String getModelChoosed() {
		return modelChoosed;
	}

	public void setModelChoosed(String modelChoosed) {
		this.modelChoosed = modelChoosed;
	}

	public String getColorChoosed() {
		return colorChoosed;
	}

	public void setColorChoosed(String colorChoosed) {
		this.colorChoosed = colorChoosed;
	}

	public double getPriceChoosed() {
		return priceChoosed;
	}

	public void setPriceChoosed(double priceChoosed) {
		this.priceChoosed = priceChoosed;
	}

	public void setFinalPrice() {
		priceChoosed = priceChoosed + Colors.getPrice(colorChoosed);
	}

}
