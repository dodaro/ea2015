package persistence.product;

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

	
	private static final long serialVersionUID = 6514977362529988050L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name", length = 255, unique = false, nullable = false)
	private String name;
	
	@Column(name = "price", length = 255, unique = false, nullable = false)
	private double price;
	
	//foreign key (since I have just one store)
	@Column(name = "store", length = 255, unique = false, nullable = false)
	private long store;

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

	public void setPrice(double price) {
		this.price = price;
	}

	public long getStore() {
		return store;
	}

	public void setStore(long store) {
		this.store = store;
	}

}
