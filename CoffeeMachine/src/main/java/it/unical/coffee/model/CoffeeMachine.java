package it.unical.coffee.model;

public class CoffeeMachine {
	
	private String[] products;
	private Integer insertedMoney;
	
	public CoffeeMachine() {
	}
	
	public Integer getInsertedMoney() {
		return insertedMoney;
	}
	
	public void setInsertedMoney(Integer insertedMoney) {
		this.insertedMoney = insertedMoney;
	}

	public Integer computeChange() {
		Integer sum = 0;
		for(int i = 0; i < products.length; i++)
			sum += Product.getPrice(products[i]);
		return insertedMoney - sum;
	}
	
	public void setProducts(String[] products) {
		this.products = products;
	}
	
	public String[] getProducts() {
		return products;
	}
}
