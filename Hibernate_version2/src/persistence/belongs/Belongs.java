package persistence.belongs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import persistence.product.Product;
import persistence.purchase.Purchase;

/*
 * The Class Belongs is representative of the many to many relation between a Purchase
 * and a Product. A Product here is considered as a category so that it can be bought more
 * than once.
 * 
 */
@Entity
@Table(name = "belongs")
public class Belongs implements Serializable{

	private static final long serialVersionUID = 7409823420025414166L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "purchase")
	private Purchase purchase;
	
	@ManyToOne
	@JoinColumn(name = "product")
	private Product product;
	
	public Belongs() {
		setPurchase(null);
		setProduct(null);
	}
	
	public Belongs(Purchase purchase, Product product){
		
		this.setPurchase(purchase);
		this.setProduct(product);
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
