package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5941041760744793964L;

	@Id
	@Column(name = "code")
	private Integer code;

	@Column(name = "name", length = 255, unique = true, nullable = false)
	private String name;

	@Column(name = "category", length = 255, nullable = false)
	private String category;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "price", nullable = false)
	private Integer price;

	@Column(name = "manufacturer", length = 255, nullable = false)
	private String manufacturer;

	@Column(name = "available", nullable = false)
	private boolean available;

	public Product() {
		code = 0;
		name = "";
		category = "";
		description = "";
		price = 0;
		manufacturer = "";
		available = true;
	}

	public Product(Integer code, String name, String category, String description, Integer price, String manufacturer,
			Boolean available) {
		this.code = code;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.manufacturer = manufacturer;
		this.available = available;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {

		return code + " : " + name + " - " + price;
	}

}
