package persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO {

	public UserDAOImpl() {
	}

	@Override
	public void create(User user) {
		Session session = Connect.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);		
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void update(User user) {
		Session session = Connect.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);		
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(User user) {
		Session session = Connect.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}	

	@Override
	public User get(Integer id) {
		Session session = Connect.getSessionFactory().openSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where id = " + id)
				.addEntity(User.class).uniqueResult();
		session.close();
		return user;
	}

	@Override
	public User get(String username) {
		Session session = Connect.getSessionFactory().openSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where username = '" + username + "'")
				.addEntity(User.class).uniqueResult();
		session.close();
		return user;
	}
	
	@Override
	public int numberOfUsers() {
		Session session = Connect.getSessionFactory().openSession();
		int size = session.createSQLQuery("SELECT * FROM users").list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		Session session = Connect.getSessionFactory().openSession();
		List<User> users = (List<User>) session.createSQLQuery("SELECT * FROM users").addEntity(User.class).list();
		session.close();
		return users;
	}
}
