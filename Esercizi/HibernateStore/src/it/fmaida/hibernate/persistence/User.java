package it.fmaida.hibernate.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Purchase> purchases;
	
	
	public User() {
		this.id = 0;
		this.username = "";
		this.firstName = "";
		this.lastName = "";
		this.Address = "";
		this.password = "";
		this.birthDate = null;
		this.purchases = new ArrayList<>();
	}
	
	public User(int id,String username,String firstName,String lastName,String address,String password,Date birthDate) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Address = address;
		this.password = password;
		this.birthDate = birthDate;
		this.purchases = new ArrayList<>();
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
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	
	public List<Purchase> getPurchases() {
		return purchases;
	}
	
	@Override
	public String toString() {
		return id + " " + username + " " + firstName + " " + lastName + " " + Address + " " + birthDate.toString() ;
	}
	

}
