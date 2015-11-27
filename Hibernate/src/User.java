public class User {

}

/**
 * 
 */


@

public User() {
	id = 0;
	username = "";
	password = "";
	name = "";
	surname = "";
	email = "";
}

public User(Integer id, String username, String password, String name, String surname, String email) {
	this.id = id;
	this.username = username;
	this.password = password;
	this.name = name;
	this.surname = surname;
	this.email = email;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public String toString() {

	return id + ": " + username + " - " + password;
}
}