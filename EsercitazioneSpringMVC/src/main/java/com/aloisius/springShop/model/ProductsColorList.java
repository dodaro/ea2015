package com.aloisius.springShop.model;

import java.util.ArrayList;

public class ProductsColorList {
	private ArrayList<ProductColor> productsColor;
	
	public ProductsColorList() {
		productsColor = Helper.getLoadedProductsColor();
	}

	public ArrayList<ProductColor> getProductsColor() {
		return productsColor;
	}

	public void setProductsColor(ArrayList<ProductColor> productsColor) {
		this.productsColor = productsColor;
	}

}
