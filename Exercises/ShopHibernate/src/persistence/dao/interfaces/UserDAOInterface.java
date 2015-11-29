package persistence.dao.interfaces;

import java.util.List;
import java.util.Set;

import persistence.data.Product;
import persistence.data.Purchase;
import persistence.data.User;

public interface UserDAOInterface {

	public void create(User user);
	public void update(User user);
	public void delete(User user);
	
	public User get(String username);
	
	public List<User> getAllUsers();
	public List<Purchase> getUserPurchases(User user);
	public Set<Product> getUserPurchaseProducts(User user);
	
}
