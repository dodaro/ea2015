package it.unical.hibernate.data;

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
	private static final long serialVersionUID = -1931025728534058135L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int ID;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "address", length = 100, nullable = false)
	private String address;
	
	@Column(name = "city", length = 50, nullable = false)
	private String city;
	
	@Column(name = "region", length = 50, nullable = false)
	private String region;
	
	@Column(name = "state", length = 50, nullable = false)
	private String state;
	
	
	public Shop() {

		this.ID = 0;
		this.name = "";
		this.description = "";
		this.address = "";
		this.city = "";
		this.region = "";
		this.state = "";
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Shop [ID=" + ID + ", name=" + name + ", description=" + description + ", address=" + address + ", city="
				+ city + ", region=" + region + ", state=" + state + "]";
	}
	
}
