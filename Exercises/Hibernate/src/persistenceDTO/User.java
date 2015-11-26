package persistenceDTO;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 *	RISPETTO ALLA CLASSE FATTA DA DODARO A LEZIONE HO SOLO AGGIUNTO DEI NUOVI CAMPI, IN QUANTO UN GENERICO UTENTE NON DIFFERISCE 
 *  CONCETTUALMENTE DA QUELLO DI DODARO.
 *  
 */
 

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username", length = 255, unique = true, nullable = false)
	private String username;

	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "surname", length = 255, nullable = false)
	private String surname;
	
	@Column(name = "address", length = 255, nullable = false)
	private String address;

	
	
	public User() {
		this.id = 0;
		this.username = "";
		this.password = "";
		this.name="";
		this.surname="";
		this.address="";
	}

	public User(Integer id, String username, String password,String name, String surname, String address) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name=name;
		this.surname=surname;
		this.address=address;
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
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}