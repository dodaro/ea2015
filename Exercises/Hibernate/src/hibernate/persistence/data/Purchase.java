package hibernate.persistence.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "purchases")
@SequenceGenerator(name = "purchaseGenerator", sequenceName = "purchaseSequence", initialValue = 1)
public class Purchase implements Serializable {

	private static final long serialVersionUID = 3646703685590977719L;

	private static final int NO_ID = -1;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchaseGenerator")
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	@ManyToOne
	@JoinColumn(name = "product")
	private Product product;

	@Temporal(TemporalType.DATE)
	private Date date;

	public Purchase(User user, Product product, Date date) {
		this.id = NO_ID;
		this.user = user;
		this.product = product;
		this.date = date;
	}

	public Purchase() {
		this.id = NO_ID;
		this.user = null;
		this.product = null;
		this.date = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Purchase " + id + ": user " + user.getId() + " (" + user.getUsername()
				+ ") bought product " + product.getId() + " (" + product.getName() + ")";
	}
}
