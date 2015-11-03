package it.unical.distributor.model;

public class Distributor {
	private String nameProduct1;
	private float priceProduct1;
	private String nameProduct2;
	private float priceProduct2;
	private String nameProduct3;
	private float priceProduct3;
	private String nameProduct4;
	private float priceProduct4;
		
	public Distributor(){
		nameProduct1 = "Coffee";
		priceProduct1 = 0.5f;
		nameProduct2 = "Milk";
		priceProduct2 = 0.8f;
		nameProduct3 = "Sugar Fruit";
		priceProduct3 = 1.0f;
		nameProduct4 = "Tea";
		priceProduct4 = 0.6f;		
	}

	public String getNameProduct1() {
		return nameProduct1;
	}

	public void setNameProduct1(String nameProduct1) {
		this.nameProduct1 = nameProduct1;
	}

	public float getPriceProduct1() {
		return priceProduct1;
	}

	public void setPriceProduct1(float priceProduct1) {
		this.priceProduct1 = priceProduct1;
	}

	public String getNameProduct2() {
		return nameProduct2;
	}

	public void setNameProduct2(String nameProduct2) {
		this.nameProduct2 = nameProduct2;
	}

	public float getPriceProduct2() {
		return priceProduct2;
	}

	public void setPriceProduct2(float priceProduct2) {
		this.priceProduct2 = priceProduct2;
	}

	public String getNameProduct3() {
		return nameProduct3;
	}

	public void setNameProduct3(String nameProduct3) {
		this.nameProduct3 = nameProduct3;
	}

	public float getPriceProduct3() {
		return priceProduct3;
	}

	public void setPriceProduct3(float priceProduct3) {
		this.priceProduct3 = priceProduct3;
	}

	public String getNameProduct4() {
		return nameProduct4;
	}

	public void setNameProduct4(String nameProduct4) {
		this.nameProduct4 = nameProduct4;
	}

	public float getPriceProduct4() {
		return priceProduct4;
	}

	public void setPriceProduct4(float priceProduct4) {
		this.priceProduct4 = priceProduct4;
	}
	
}
