package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shops")
public class Shop implements Serializable 
{
	private static final long serialVersionUID = 7934359787234272027L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "partitaIVA", length = 11, unique = true, nullable = false)
	private String partitaIVA;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "location", length = 255, nullable = false)
	private String location;
	
	public Shop()
	{
		this.id = 0;
		this.partitaIVA = "";
		this.name = "";
		this.location = "";
	}

	public Shop(Integer id, String partitaIVA, String name, String location)
	{
		this.id = id;
		this.partitaIVA = partitaIVA;
		this.name = name;
		this.location = location;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getPartitaIVA()
	{
		return partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA)
	{
		this.partitaIVA = partitaIVA;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}
	
	@Override
	public String toString()
	{
		return "Shop [id=" + id + ", partitaIVA=" + partitaIVA + ", name=" + name + ", location=" + location + "]";
	}
}