package persistence;

import java.util.List;

public interface UserDAO {
	
	
	public void create(User user);
	
	public void update(User user);
	
	public void delete(User user);
	
	public List<User> getUsers();
	
	public User getUserByUsername(String username);
	
	public List<Product> getBoughtByUser(String username);
}
