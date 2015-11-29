package persistence.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import persistence.dao.interfaces.UserDAOInterface;
import persistence.data.Product;
import persistence.data.Purchase;
import persistence.data.User;
import persistence.handler.DBHandler;

public class UserDAO implements UserDAOInterface{

	
	@Override
	public void create(User user) {
		DBHandler.create(user);
	}
	
	@Override
	public void update(User user) {
		DBHandler.update(user);
	}
	
	@Override
	public void delete(User user) {
		DBHandler.delete(user);
	}
	
	@Override
	public User get(String username) {
		
		Session session = DBHandler.getSession();
		User user = (User) session.createQuery("from User where username='" + username + "'").uniqueResult();
		session.close();
		
		return user;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {

		Session session = DBHandler.getSession();
		List<User> users = (List<User>) session.createQuery("from User").list();
		session.close();
		
		return users;
	}
	
	
	// function only for exercise me it is not really needed
	// is not needed to have in user a backpointer to the list of purchase
	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> getUserPurchases(User user) {
		
		Session session = DBHandler.getSession();
//		List<Purchase> userPurchases = (List<Purchase>) session.createQuery("from Purchase where user_username='" + user.getUsername()  +"'").list();
		List<Purchase> userPurchases = (List<Purchase>) session.createQuery("select userPurchases from User where username='" + user.getUsername()  +"'").list();
		session.close();
		
		return userPurchases;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Product> getUserPurchaseProducts(User user) {

		Session session = DBHandler.getSession();
		Set<Product> products = new HashSet<>((List<Product>) session.createQuery(
				"select p from Product p, SinglePurchase sp, Purchase pu "
				+ "where p.ID=sp.product and sp.purchase=pu.ID and pu.user_username='" + user.getUsername() + "'").list());
		session.close();
		
		return products;
	}
	
}
