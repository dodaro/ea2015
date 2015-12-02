package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

public class UserDAOImpl implements UserDAO {

	private final static String SELECT = "SELECT * from users";
	private final static String SELECT_ByUserName = "SELECT * FROM users where username = '";

	
	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void create(User user) {
		SessionManager.create(user);

	}

	@Override
	public void update(User user) {
		SessionManager.update(user);

	}

	@Override
	public void delete(User user) {
		SessionManager.delete(user);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		Session session = SessionManager.getSession();
		List<User> users = (List<User>) session.createSQLQuery(SELECT).addEntity(User.class).list();
		session.close();
		return users;
	}

	@Override
	public User getUserByUsername(String username) {
		Session session = SessionManager.getSession();
		User user = (User) session.createSQLQuery(SELECT_ByUserName + username + "'").addEntity(User.class)
				.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public List<Product> getBoughtByUser(String username) {
		List<Product> products = new ArrayList<Product>();
		Session session = SessionManager.getSession();
		User us = getUserByUsername(username);
		if (us != null) {
			for (Purchase p : us.getPurchases()) {
				Hibernate.initialize(p);
				products.add(p.getProduct());
			}
		}
		session.close();
		return products;
	}

}
