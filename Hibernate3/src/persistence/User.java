package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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

	@ManyToMany(mappedBy = "users")
	private List<Promotion> promotions;

	public User() {
		id = 0;
		username = "";
		password = "";
		promotions = new ArrayList<Promotion>();
	}

	public User(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.promotions = new ArrayList<Promotion>();
	}

	public User(Integer id, String username, String password, List<Promotion> promotions) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.promotions = promotions;
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

	public List<Promotion> getPromotions() {
		return promotions;
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

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public void addPromotion(Promotion p) {
		promotions.add(p);
	}

	@Override
	public String toString() {
		return id + ": " + username + " - " + password;
	}
}
