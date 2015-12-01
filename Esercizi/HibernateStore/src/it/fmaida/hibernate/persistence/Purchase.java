package it.fmaida.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="purchases")
public class Purchase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5018049524678550365L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "purchase_date", nullable = false)
	private Date purchaseDate;
	
	@OneToMany(mappedBy = "purchase",fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<ItemPurchase> itemPurchases;
	
	public Purchase() {
		this.id = 0;
		this.user = null;
		this.itemPurchases = null;
		this.purchaseDate = null;
	}
	
	public Purchase(int id,User user,List<ItemPurchase> itemPurchases,Date date) {
		this.id = id;
		this.user = user;
		this.itemPurchases = itemPurchases;
		this.purchaseDate = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ItemPurchase> getItemPurchases() {
		return itemPurchases;
	}
	
	public void setItemPurchases(List<ItemPurchase> itemPurchases) {
		this.itemPurchases = itemPurchases;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
	
}
