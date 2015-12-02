package persistence;

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
	private static final long serialVersionUID = 402666623662772127L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username", length = 255, unique = true, nullable = false)
	private String username;

	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@Column(name = "firstName", length = 255, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 255, nullable = false)
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthDate", nullable = false)
	private Date birthDate;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Purchase> purchases;

	public User() {
		id = 0;
		username = "";
		password = "";
		firstName = "";
		lastName  = "";
		birthDate = new Date();
		purchases = new ArrayList<Purchase>();
	}	
	
	public User(Integer id, String username, String password, String firstName,
			String lastName, Date birthDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.purchases = new ArrayList<Purchase>();
	}

	public User(Integer id, String username, String password, String firstName,
			String lastName, Date birthDate, List<Purchase> purchases) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.purchases = purchases;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return id + ": " + username + " - " + password + " - " + firstName + " - " + lastName + " - " + birthDate;
	}
}
