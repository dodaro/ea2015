package persistence.user;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StringType;


public class ConcreteUserDAO implements UserDAO{

	private static SessionFactory factory;
	
	public ConcreteUserDAO() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}
	
	@Override
	public User find(long id) {
		
		Session session = factory.openSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where id = " + id).addEntity(User.class)
				.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public List<User> getUsers() {
		
		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) session.createSQLQuery("SELECT * FROM users").addEntity(User.class).list();
		session.close();
		return users;
	}

	@Override
	public String getUsername(long id) {
		
		Session session = factory.openSession();
		String username = (String) session.createSQLQuery("SELECT * FROM users where id = " + id).addScalar("username", StringType.INSTANCE)
				.uniqueResult();
				
		session.close();
		return username;
	}

	@Override
	public String getPassword(long id) {
		
		Session session = factory.openSession();
		String username = (String) session.createSQLQuery("SELECT * FROM users where id = " + id).addScalar("password", StringType.INSTANCE)
				.uniqueResult();
				
		session.close();
		return username;
	}

	@Override
	public List<User> getUserFromCity(String city) {
		
		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) session.createSQLQuery("SELECT * FROM users where city = '" + city +"'").addEntity(User.class).list();
		session.close();
		return users;
	}

	@Override
	public void create(User user) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);		
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}	
	}

	@Override
	public void updateUser(User user) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(user);		
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public void updateUsername(String username, long id) {
		
		User user = find(id);
		user.setName(username);
		updateUser(user);
		
	}

	@Override
	public void delete(User user) {
		
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	
}
