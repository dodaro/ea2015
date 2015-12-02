package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7082295613055612514L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", length = 255, unique = true, nullable = false)
	private String name;

	@Column(name = "description", length = 255, nullable = false)
	private String description;

	@Column(name = "price", length = 255, nullable = false)
	private float price;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Purchase> purchases;
	
	public Product() {
		id = 0;
		name = "";
		description = "";
		price = 0.0f;
		purchases = new ArrayList<Purchase>();
	}
	
	public Product(Integer id, String name, String description, float price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.purchases = new ArrayList<Purchase>();
	}

	public Product(Integer id, String name, String description, float price, List<Purchase> purchases) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.purchases = purchases;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return id + ": " + name + " - " + description + " - " + price;
	}
}
