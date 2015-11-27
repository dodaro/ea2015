package it.fmaida.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="shops")
public class Shop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2067208828004134216L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name",length=255,unique=false,nullable=false)
	private String name;
	
	@Column(name="city",length=255,unique=false,nullable=false)
	private String city;
	
	public Shop() {
		this.id = 0;
		this.name = "";
		this.city = "";
	}
	
	public Shop(int id,String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
}
