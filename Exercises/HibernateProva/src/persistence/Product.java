package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8514850694371646742L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "prodname", length = 255, unique = true, nullable = false)
	private String prodname;
	
	@Column(name = "price", length = 255, nullable = false)
	private double price;
	
	@Column(name = "category", length = 255)
	private String category;
	
	public Product() {
		id = 0;
		prodname = "";
		price = 0;
		category = "";
	}

	/**
	 * @param id
	 * @param prodname
	 * @param price
	 * @param category
	 */
	public Product(Integer id, String prodname, double price, String category) {
		this.id = id;
		this.prodname = prodname;
		this.price = price;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return id + ": " + prodname + ", Price: " + price + ", Category: " + category;
	}

}




