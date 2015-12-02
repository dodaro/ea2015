package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private static final long serialVersionUID = 5941041760744793964L;

	@Id
	@Column(name = "code")
	private int code;

	@Column(name = "name", length = 255, unique = true, nullable = false)
	private String name;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "price", nullable = false)
	private int price;

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Purchase> purchases;
	
	public Product() {
		code = 0;
		name = "";
		description = "";
		price = 1;
		purchases=new ArrayList<Purchase>();
	}

	public Product(int id, String name, String description, int price) {
		this.code = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Product(int id, String name, String description, int price, List<Purchase> purchases) {
		this.code = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.purchases=purchases;
	}
	
	public int getId() {
		return code;
	}

	public void setId(int id) {
		this.code = id;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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
		return name;
	}

}
