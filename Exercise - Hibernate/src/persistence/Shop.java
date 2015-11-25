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
public class Shop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6444340550121791501L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", length = 255, unique = true, nullable = false)
	private String name;

	@Column(name = "address", length = 255, nullable = false)
	private String address;

	public Shop() {
		id = 0;
		name = "";
		address = "";
	}	

	public Shop(Integer id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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

	@Override
	public String toString() {
		return id + ": " + name + " - " + address;
	}
}
