package persistenceDTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stores")
public class Store implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "address", length = 255, nullable = false)
	private String address;
	
	@Column(name = "city", length = 255, nullable = false)
	private String city;
	
	public Store() {
		// TODO Auto-generated constructor stub
		this.id=0;
		this.name="";
		this.name="";
		this.city="";
	}
	
	public Store(Integer id, String name, String address, String city) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.address=address;
		this.city=city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
}
