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
public class Product implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -66293034449426878L;

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
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Purchase> purchases;
	
	public Product() {
		this.id = 0;
		this.prodname = "";
		this.price = 0;
		this.category = "";
		this.purchases = new ArrayList<Purchase>();
	}

	public Product(Integer id, String prodname, double price, String category) {
		this.id = id;
		this.prodname = prodname;
		this.price = price;
		this.category = category;
		this.purchases = new ArrayList<Purchase>();
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

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return prodname + ", Price: " + price;
	}

}




