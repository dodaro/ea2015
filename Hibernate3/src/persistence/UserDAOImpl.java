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
		user.getPromotions().size();
		session.close();
		return user;
	}

	@Override
	public User get(String username) {
		Session session = DBHandler.getSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where username = '" + username + "'")
				.addEntity(User.class).uniqueResult();
		session.close();
		return user;
	}	
}
