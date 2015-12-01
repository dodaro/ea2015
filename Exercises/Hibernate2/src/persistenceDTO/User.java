package persistenceDTO;

import java.io.Serializable;


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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username", length = 255, unique = true, nullable = false)
	private String username;

	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "surname", length = 255, nullable = false)
	private String surname;
	
	@Column(name = "address", length = 255, nullable = false)
	private String address;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth", nullable = false)
	private Date birth;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Purchase> purchase;

	
	
	public User() {
		this.id = 0;
		this.username = "";
		this.password = "";
		this.name="";
		this.surname="";
		this.address="";
		this.birth=new Date();
		this.purchase=new ArrayList<Purchase>();
	}

	public User(Integer id, String username, String password,String name, String surname, String address, Date birth, List<Purchase> purchase) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name=name;
		this.surname=surname;
		this.address=address;
		this.birth=birth;
		this.purchase=purchase;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public List<Purchase> getPurchase() {
		return purchase;
	}

	public void setPurchase(List<Purchase> purchase) {
		this.purchase = purchase;
	}
	
	
}