package persistence.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "singlePurchase")
public class SinglePurchase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2884435688871240527L;

	
	@Id
	@ManyToOne
	@JoinColumn(name = "product")
	private Product product;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "purchase")
	private Purchase purchase;
	
	public SinglePurchase() {

		this.product = null;
		this.purchase = null;
	}
	
	public SinglePurchase(Product product, Purchase purchase) {

		this.product = product;
		this.purchase = purchase;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	@Override
	public String toString() {
		return "SinglePurchase [product=" + product + ", purchase=" + purchase + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((purchase == null) ? 0 : purchase.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinglePurchase other = (SinglePurchase) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (purchase == null) {
			if (other.purchase != null)
				return false;
		} else if (!purchase.equals(other.purchase))
			return false;
		return true;
	}
	
}
