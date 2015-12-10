package it.unical.carseller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="colors")
public class Color {
	
	@Id
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="price", nullable=false)
	private Double price;
	
	@Column(name="imgUrl", nullable=false)
	private String imgUrl;
	
	public Color() {
		this.name = "";
		this.price = 0.0;
		this.imgUrl = "";
	}
	
	public Color(String name, Double price, String imgUrl) {
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String color) {
		this.name = color;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	@Override
	public String toString() {
		return this.name + " (" + this.price + " euro)";  
	}
}
