package persistence.user;

import java.util.List;


public interface UserDAO {

	//read
	public User find(long id);
	public List<User> getUsers();
	public String getUsername(long id);
	public String getPassword(long id);
	public List<User> getUserFromCity(String city);
	
	//creation
	public void create(User user);
	
	//update
	public void updateUser(User user);
	public void updateUsername(String username, long id);
	
	//delete
	public void delete(User user);
	
	
}
