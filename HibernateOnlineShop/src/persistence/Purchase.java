package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "purchases")
public class Purchase implements Serializable
{
	private static final long serialVersionUID = 6237776025942845825L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "id_user")
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "id_product")
	private Product product;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false)
	private Date date;
	
	public Purchase()
	{}	

	public Purchase(Integer id, User user, Product product, Date date)
	{
		this.id = id;
		this.user = user;
		this.product = product;
		this.date = date;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	@Override
	public String toString()
	{
		return "Purchase [id=" + id + ", user=" + user + ", product=" + product + ", date=" + date + "]";
	}	
}