package it.fmaida.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itempurchases")
public class ItemPurchase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4124984582854826712L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "purchase")
	private Purchase purchase;
	
	@ManyToOne
	@JoinColumn(name = "item")
	private Item item;
	
	public ItemPurchase() {
		this.id = 0;
		this.purchase = null;
		this.item = null;
	}
	
	public ItemPurchase(int id,Purchase purchase, Item item) {
		this.id = id;
		this.purchase = purchase;
		this.item = item;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Purchase getPurchase() {
		return purchase;
	}
	
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	

}
