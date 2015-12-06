package hibernate.persistence.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "userGenerator", sequenceName = "userSequence", initialValue = 1)
public class User implements Serializable {

	private static final long serialVersionUID = -3646392119740913504L;

	private static final int NO_ID = -1;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userGenerator")
	@Column(name = "id")
	private Integer id;

	@Column(name = "username", length = 255, unique = true, nullable = false)
	private String username;

	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@Column(name = "first_name", length = 255, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 255, nullable = false)
	private String lastName;

	@Column(name = "address", length = 255, nullable = false)
	private String address;

	public User() {
		this.id = NO_ID;
		this.username = "";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.address = "";
	}

	public User(String username, String password, String firstName, String lastName,
			String address) {
		this.id = NO_ID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User " + id + ": " + username + ", " + password;
	}
}
