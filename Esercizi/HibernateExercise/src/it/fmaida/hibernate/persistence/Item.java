package it.fmaida.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1583340479020064783L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column ( name = "name", length = 255, unique = true, nullable = false)
	private String name;
	@Column ( name = "category", length = 255, unique = false, nullable = false)
	private String category;
	@Column ( name = "price", length = 255, unique = false, nullable = false)
	private Float price;
	
	public Item() {
		this.id = 0;
		this.name = "";
		this.category = "";
		this.price = 0.0f;
	}
	
	public Item(int id,String name,String category,float price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + category + " " + price;
	}
	
}
