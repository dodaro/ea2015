package persistence;

import java.util.List;

public interface UserDAO {
	public void create(User user) throws Exception;
	
	public void update(User user) throws Exception;

	public void delete(User user) throws Exception;

	public User get(Integer id);

	public User get(String username);

	public int numberOfUsers();

	public List<User> getUsers();
}
