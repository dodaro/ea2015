package it.unical.carseller.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="username", nullable=false, length=20)
	@Size(min=4, max=20)
	private String username;
	
	@Column(name="password", nullable=false, length=50)
	@Size(min = 6, max = 50)
	private String password;
	
	@Column(name="email", nullable=false, length=200)
	@Size(max=200)
	@Email()
	@NotEmpty()
	private String email;
	
	@Column(name="age", nullable=false)	
	@Min(18) @Max(130)
	@NotNull
	private Integer age;
	
	@Column(name="dateOfBirth", nullable=false)
	@Temporal(TemporalType.DATE)
	@NotNull(message="The date of birth must be set")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Past()	
	private Date dateOfBirth;	
	
	public User(){
		username = "";
		password = "";
		email = "";
		age = 18;
		dateOfBirth = null;
	}
	
	public User(String username, String password, String email, Integer age, Date dateOfBirth) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
		this.dateOfBirth = dateOfBirth;  
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", age=" + age
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}	
}