package it.unical.login.model;

public class User {
	private String username;
	private String password;
	
	public User(){
		username = new String("");
		password = new String("");
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
}
