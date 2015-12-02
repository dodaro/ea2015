package persistence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable
{
	private static final long serialVersionUID = 5941041760744793964L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_product")
	private Integer id;

	@Column(name = "name", length = 255, nullable = false)
	private String name;

	@Column(name = "description", length = 255, nullable = false)
	private String description;
	
	@Column(name = "price", nullable = false)
	private Float price;
	
	@OneToMany(mappedBy = "product")
	private Set<Purchase> purchases;

	public Product()
	{
		this.id = 0;
		this.name = "";
		this.description = "";
		this.price = .0f;
		this.purchases =  new HashSet<Purchase>();
	}
	
	public Product(Integer id, String name, String description, Float price)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.purchases =  new HashSet<Purchase>();
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Float getPrice()
	{
		return price;
	}

	public void setPrice(Float price)
	{
		this.price = price;
	}
	
	public Set<Purchase> getPurchases()
	{
		return purchases;
	}

	public void setPurchases(Set<Purchase> purchases)
	{
		this.purchases = purchases;
	}
	
	public void addPurchase(Purchase purchase)
	{
		this.purchases.add(purchase);
	}

	@Override
	public String toString()
	{
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Product p = (Product) obj;
		return (obj instanceof Product && this.id == p.getId());
	}
}
