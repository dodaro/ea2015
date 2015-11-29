package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4619651034034731538L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username", length = 255, unique = true, nullable = false)
	private String username;

	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Booking> bookings;

	public User() {
		id = 0;
		username = "";
		password = "";
		bookings = new ArrayList<Booking>();
	}

	public User(Integer id, String username, String password, List<Booking> bookings) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.bookings = bookings;
	}

	public User(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
		bookings = new ArrayList<Booking>();
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

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return id + ": " + username + " - " + password;
	}
}
