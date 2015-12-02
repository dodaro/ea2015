package persistence;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private static final long serialVersionUID = -633766408662404568L;

	@Id
	@Column(name = "username", length = 255)
	private String username;

	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@Column(name = "firstName", length = 255, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 255, nullable = false)
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name = "dBirth")
	private Date dBirth;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Purchase> purchases;

	public User() {
		username = "";
		password = "";
		firstName = "";
		lastName = "";
		dBirth = new Date();
		purchases = new ArrayList<Purchase>();
	}

	public User(String username, String password, String firstName, String lastName, Date dBirth) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dBirth = dBirth;
	}

	public User(String username, String password, String firstName, String lastName, Date dBirth,
			List<Purchase> purchases) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dBirth = dBirth;
		this.purchases = purchases;
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

	public Date getdBirth() {
		return dBirth;
	}

	public void setdBirth(Date dBirth) {
		this.dBirth = dBirth;
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


	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	@Override
	public String toString() {
		return username;
	}
}