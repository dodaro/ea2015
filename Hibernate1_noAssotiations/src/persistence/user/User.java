package persistence.user;

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

	private static final long serialVersionUID = -4872477028175789800L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "username", length = 255, unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", length = 255, unique = true, nullable = false)
	private String password;
	
	@Column(name = "city", length = 255, unique = false, nullable = false)
	private String city;
	
	
	public User() {
		setId(0);
		setName("");
		setPassword("");
		setCity("");
	}
	
	public User(String username, String password, String city){
	
		this.username = username;
		this.password = password;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
