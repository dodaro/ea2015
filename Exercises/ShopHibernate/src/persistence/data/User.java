package persistence.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "users")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3637711181869860027L;
	
	@Id
	@Column(name = "username", length = 20, nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	@Column(name = "age", length = 3)
	private int age;
	
	
	@OneToMany(mappedBy = "user_username", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Purchase> userPurchases;
	
	
	public User() {

		this.username = "";
		this.password = "";
		this.email = "";
		this.age = 0;
		this.userPurchases = new ArrayList<Purchase>();
	}


	public User(String username, String password) {
		this();

		this.username = username;
		this.password = password;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	

	
	public List<Purchase> getUserPurchases() {
		return userPurchases;
	}


	public void setUserPurchases(List<Purchase> userPurchases) {
		this.userPurchases = userPurchases;
	}
	


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", age="
				+ age + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
