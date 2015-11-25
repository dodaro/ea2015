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
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3850709420382824533L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", length = 255, unique = true, nullable = false)
	private String name;

	@Column(name = "price", length = 255, nullable = false)
	private float price;

	public Product() {
		id = 0;
		name = "";
		price = 0.0f;
	}

	public Product(Integer id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return id + ": " + name + " - " + price;
	}
}
