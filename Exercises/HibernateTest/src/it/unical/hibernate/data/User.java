package it.unical.hibernate.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3637711181869860027L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int ID;
	
	@Column(name = "username", length = 20, nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	@Column(name = "email", length = 255, nullable = false)
	private String email;
	
	@Column(name = "age", length = 3)
	private int age;
	
	
	public User() {

		this.ID = 0;
		this.username = "";
		this.password = "";
		this.email = "";
		this.age = 0;
	}


	public User(int ID, String username, String password) {
		this();

		this.ID = ID;
		this.username = username;
		this.password = password;
	}
	
	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
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


	public void setAge(Byte age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "User [ID=" + ID + ", username=" + username + ", password=" + password + ", email=" + email + ", age="
				+ age + "]";
	}

}
