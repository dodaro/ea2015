package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product implements Serializable 
{
	private static final long serialVersionUID = 2892830212438497061L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "brand", length = 255, nullable = false)
	private String brand;
	
	@Column(name = "category", length = 255, nullable = false)
	private String category;
	
	@Column(name = "price", nullable = false)
	private Float price;
	
	public Product()
	{
		this.id = 0;
		this.name = "";
		this.brand = "";
		this.category = "";
		this.price = .0f;
	}

	public Product(Integer id, String name, String brand, String category, Float price)
	{
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.price = price;
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

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public Float getPrice()
	{
		return price;
	}

	public void setPrice(Float price)
	{
		this.price = price;
	}
	
	@Override
	public String toString()
	{
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", price="
				+ price + "]";
	}
}