package hibernate.persistence.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "products")
@SequenceGenerator(name = "productGenerator", sequenceName = "productSequence", initialValue = 1)
public class Product {

	private static final int NO_ID = -1;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productGenerator")
	private int id;

	@Column(name = "name", length = 255, nullable = false)
	private String name;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "price", nullable = false)
	private double price;

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Purchase> purchases;

	public Product() {
		this.id = NO_ID;
		this.name = "";
		this.description = "";
		this.price = 0.0;
	}

	public Product(String name, String description, double price) {
		this.id = NO_ID;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product " + id + ": " + name + ", " + description + ", " + price;
	}
}
