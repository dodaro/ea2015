package persistence;

import java.util.List;

import org.hibernate.Session;

public class UserDAOImpl implements UserDAO {

		
	public UserDAOImpl() {
	}

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
	public int numberOfUsers() {
		Session session = DBHandler.getSession();
		int size = session.createSQLQuery("SELECT * FROM users").list().size();
		session.close();
		return size;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Session session = DBHandler.getSession();
		List<User> users = (List<User>) session.createSQLQuery("SELECT * FROM users").addEntity(User.class).list();
		session.close();
		return users;
	}

	@Override
	public User get(Integer id) {
		Session session = DBHandler.getSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where id = " + id).addEntity(User.class)
				.uniqueResult();		
		//user.getBookings().size();
		// if (user != null) {
		// for (Booking b : user.getBookings()) {
		// Hibernate.initialize(b);
		// }
		// }
		session.close();
		return user;
	}

	@Override
	public User get(String username) {
		Session session = DBHandler.getSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where username = '" + username + "'")
				.addEntity(User.class).uniqueResult();		
//		if(user!=null)
//			user.getBookings().size();
		session.close();		
		return user;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getPurchasedProducts(User user) {
		Session session = DBHandler.getSession();
		List<Product> products = (List<Product>) session.createQuery("select distinct p.product from Purchase p where p.user=" + user.getId()).list();
		session.close();
		return products;
	}

}
