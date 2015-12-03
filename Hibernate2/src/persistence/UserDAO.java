package persistence;

import java.util.List;

public interface UserDAO {
	public void create(User user);

	public User get(Integer id);

	public User get(String username);

	public void update(User user);

	public void delete(User user);

	public int numberOfUsers();

	public List<User> getUsers();

	public List<Booking> getBookings(User user);

	public Double getTotalPrice(User user);
}
