package persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class User implements Serializable 
{
	private static final long serialVersionUID = -4619651034034731538L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user")
	private Integer id;

	@Column(name = "username", length = 255, unique = true, nullable = false)
	private String username;

	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	@Column(name = "first_name", length = 255, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 255, nullable = false)
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@OneToMany(mappedBy = "user")
	private Set<Purchase> purchases;

	public User() 
	{
		this.id = 0;
		this.username = "";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.birthDate = new Date();
		this.purchases =  new HashSet<Purchase>();
	}

	public User(Integer id, String username, String password, String firstName, String lastName, Date birthDate)
	{
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.purchases =  new HashSet<Purchase>();
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	public Set<Purchase> getPurchases()
	{
		return purchases;
	}

	public void setPurchases(Set<Purchase> purchases)
	{
		this.purchases = purchases;
	}
	
	public void addPurchase(Purchase purchase)
	{
		this.purchases.add(purchase);
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
	}
}
