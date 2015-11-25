package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
public class Shop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2936135043418043971L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "shopname", length = 255, unique = true, nullable = false)
	private String shopname;
	
	@Column(name = "address", length = 255, nullable = false)
	private String address;

	@Column(name = "city", length = 30, nullable = false)
	private String city;
	
	@Column(name = "type", length = 30, nullable = false)
	private String type;

	/**
	 * 
	 */
	public Shop() {
		this.id = 0;
		this.shopname = "";
		this.address = "";
		this.city = "";
		this.type = "";
	}

	/**
	 * @param id
	 * @param shopname
	 * @param address
	 * @param city
	 * @param type
	 */
	public Shop(Integer id, String shopname, String address, String city, String type) {
		this.id = id;
		this.shopname = shopname;
		this.address = address;
		this.city = city;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return id + ": " + shopname + ", Addr: " + address + ", City: " + city;
	}
	
	
	
}




