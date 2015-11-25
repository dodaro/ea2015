package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable 
{
	private static final long serialVersionUID = 4667186840523777725L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "surname", length = 255, nullable = false)
	private String surname;
	
	@Column(name = "birthLocation", length = 255, nullable = false)
	private String birthLocation;

	public Client()
	{
		this.id = 0;
		this.name = "";
		this.surname = "";
		this.birthLocation = "";
	}

	public Client(Integer id, String name, String surname, String birthLocation)
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthLocation = birthLocation;
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

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getBirthLocation()
	{
		return birthLocation;
	}

	public void setBirthLocation(String birthLocation)
	{
		this.birthLocation = birthLocation;
	}
	
	@Override
	public String toString()
	{
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", birthLocation=" + birthLocation
				+ "]";
	}
}