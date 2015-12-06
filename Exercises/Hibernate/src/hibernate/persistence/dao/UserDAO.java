package hibernate.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.persistence.data.User;

public class UserDAO extends AbstractDAO {

	public UserDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public void create(User user) {
		performOperation(user, Operation.CREATE);
	}

	public void update(User user) {
		performOperation(user, Operation.UPDATE);
	}

	public void delete(User user) {
		performOperation(user, Operation.DELETE);
	}

	public User get(Integer id) {
		Session session = sessionFactory.openSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where id = " + id)
				.addEntity(User.class).uniqueResult();
		session.close();
		return user;
	}

	public User get(String username) {
		Session session = sessionFactory.openSession();
		User user = (User) session
				.createSQLQuery("SELECT * FROM users where username = '" + username + "'")
				.addEntity(User.class).uniqueResult();
		session.close();
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Session session = sessionFactory.openSession();
		List<User> users = (List<User>) session.createSQLQuery("SELECT * FROM users")
				.addEntity(User.class).list();
		session.close();
		return users;
	}
}