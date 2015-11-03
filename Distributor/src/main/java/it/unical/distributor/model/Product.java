package it.unical.distributor.model;

public class Product {
	private String nameProduct;
	private float priceProduct;
	
	public Product(){
		
	}
	
	public Product(String nameProduct, float priceProduct){
		this.setNameProduct(nameProduct);
		this.setPriceProduct(priceProduct);
	}
	
	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public float getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}

}
