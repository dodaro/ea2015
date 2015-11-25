package it.fmaida.hibernate.persistence;

import java.math.BigInteger;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class UserDAOImpl implements UserDAO {

	private static SessionFactory sessionFactory;
	
	public UserDAOImpl() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
	}
	
	@Override
	public void createUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch ( Exception e ) {
			if ( tx != null ) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}		
	}

	@Override
	public User get(Integer id) {
		Session session = sessionFactory.openSession();
		User user = (User) session.createSQLQuery("SELECT * from Users where id = " + id).addEntity(User.class).uniqueResult();
		session.close();
		return user;
	}

	@Override
	public User get(String username) {
		Session session = sessionFactory.openSession();
		User user = (User) session.createSQLQuery("SELECT * from Users where username = '" + username + "'").addEntity(User.class).uniqueResult();
		session.close();
		return user;
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		} catch ( Exception e ) {
			if ( tx != null ) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}		
	}

	@Override
	public void delete(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
		} catch ( Exception e ) {
			if ( tx != null ) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}		
		
	}

	@Override
	public int numberOfUsers() {
		Session session = sessionFactory.openSession();
		BigInteger n  = (BigInteger) session.createSQLQuery("SELECT count(*) from users").uniqueResult();
		session.close();
		return n.intValue();
	}

	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.openSession();
		List<User> users = session.createSQLQuery("SELECT * FROM users").addEntity(User.class).list();
		return users;
	}

}
