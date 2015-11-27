package it.fmaida.hibernate.persistence;

import java.util.List;

public interface UserDAO {

	public void createUser(User user);
	
	public User get(Integer id);

	public User get(String username);

	public void update(User user);

	public void delete(User user);

	public int numberOfUsers();

	public List<User> getUsers();

}
