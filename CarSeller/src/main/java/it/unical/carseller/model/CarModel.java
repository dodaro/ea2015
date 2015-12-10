package it.unical.carseller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="models")
public class CarModel {
	
	@Id
	@Column(name="modelName", nullable=false)
	private String name;
	
	@Column(name="price", nullable=false)
	private Double price;
	
	@Column(name="htmlPage", nullable=false)
	private String htmlPage;
		
	public CarModel() {
		this.name = "";
		this.price = 0.0;
		this.htmlPage = "";
	}
	
	public CarModel(String name, Double price, String htmlPage) {
		this.name = name;
		this.price = price;
		this.htmlPage = htmlPage;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getHtmlPage() {
		return htmlPage;
	}
	public void setHtmlPage(String htmlPage) {
		this.htmlPage = htmlPage;
	}
	
	@Override
	public String toString() {
		return this.name + " (" + this.price + " euro)";
	}
}
