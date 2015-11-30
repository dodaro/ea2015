package persistence.store;

import java.io.Serializable;
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

import persistence.product.Product;

@Entity
@Table (name = "stores")
public class Store implements Serializable{

	private static final long serialVersionUID = 8763851237565272900L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	//is the column in the other table
	@OneToMany(mappedBy = "store", fetch=FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Product> products;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
