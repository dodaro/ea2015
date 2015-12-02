package DAOIntefaces;

import java.util.List;

import persistence.User;

public interface UserDAO 
{
	public void create(User user);

	public User get(Integer id);

	public User get(String username);

	public void update(User user);

	public void delete(User user);

	public int numberOfUsers();

	public List<User> getUsers();
}
