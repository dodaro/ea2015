package persistence.user;

import java.util.List;

import persistence.purchase.Purchase;


public interface UserDAO {

	//read
	public User find(long id);
	public List<User> getUsers();
	public String getUsername(long id);
	public String getPassword(long id);
	public List<User> getUserFromCity(String city);
		
}
