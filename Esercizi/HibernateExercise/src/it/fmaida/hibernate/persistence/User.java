package it.fmaida.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4504847439944616290L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column ( name = "username", length = 255, unique = true, nullable = false)
	private String username;
	
	@Column ( name = "firstName", length = 255, unique = false, nullable = false)
	private String firstName;
	
	@Column ( name = "lastName", length = 255, unique = false, nullable = false)
	private String lastName;
	
	@Column ( name = "address", length = 255, unique = false, nullable = false)
	private String Address;
	
	@Column ( name = "password" , length = 255, unique = false, nullable = false)
	private String password;
	
	
	public User() {
		this.id = 0;
		this.username = "";
		this.firstName = "";
		this.lastName = "";
		this.Address = "";
		this.password = "";
	}
	
	public User(int id,String username,String firstName,String lastName,String address,String password) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Address = address;
		this.password = password;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return id + " " + username + " " + firstName + " " + lastName + " " + Address;
	}
	
	
	
}
