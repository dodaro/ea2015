package persistenceDTO;

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
	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "price", length = 255, nullable = false)
	private Double price;
	
	@Column(name = "discountPercentage", length = 255, nullable = true)
	private Double discountPercentage;
	
	@Column(name = "idStore", nullable = false)
	private Integer idStore;
	
	@Column(name = "producer", length = 255, nullable = false)
	private String producer;
	
	@Column(name = "description", length = 255, nullable = false)
	private String decription;
	
	@Column(name = "category", length = 255, nullable = false)
	private String category;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Purchase> purchase;
	
	public Product() {
		// TODO Auto-generated constructor stub
		this.id=0;
		this.name="";
		this.price=0.0;
		this.discountPercentage=0.0;
		this.idStore=0;
		this.producer="";
		this.category="";
		this.decription="";
		this.purchase=new ArrayList<Purchase>();
	}
	
	public Product(Integer id, String name, Double price, Double discountPercentage, Integer idStore, String producer, String category,String description,List<Purchase> purchase) {
		
		this.id=id;
		this.name=name;
		this.price=price;
		this.discountPercentage=discountPercentage;
		this.idStore=idStore;
		this.producer=producer;
		this.category=category;
		this.decription=description;
		this.purchase=purchase;
			
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Integer getIdStore() {
		return idStore;
	}

	public void setIdStore(Integer idStore) {
		this.idStore = idStore;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public List<Purchase> getPurchase() {
		return purchase;
	}

	public void setPurchase(List<Purchase> purchase) {
		this.purchase = purchase;
	}
	
	
}
