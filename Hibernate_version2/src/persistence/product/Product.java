package persistence.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import persistence.purchase.Purchase;
import persistence.user.User;


@Entity
@Table(name = "products")
public class Product implements Serializable {

	
	private static final long serialVersionUID = 6514977362529988050L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name", length = 255, unique = false, nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private float price;

	public Product(long id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public Product(){
		
		name = "";
		price = 1;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
