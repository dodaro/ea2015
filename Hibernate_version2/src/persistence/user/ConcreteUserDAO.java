package persistence.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StringType;

import persistence.purchase.Purchase;
import persistence.utils.DBHandler;


public class ConcreteUserDAO implements UserDAO{

	
	public ConcreteUserDAO() {
		
	}
	
	@Override
	public User find(long id) {
		
		Session session = DBHandler.getSession();
		User user = (User) session.createSQLQuery("SELECT * FROM users where id = " + id).addEntity(User.class)
				.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public List<User> getUsers() {
		
		Session session = DBHandler.getSession();
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) session.createSQLQuery("SELECT * FROM users").addEntity(User.class).list();
		session.close();
		return users;
	}

	@Override
	public String getUsername(long id) {
		
		Session session = DBHandler.getSession();
		String username = (String) session.createSQLQuery("SELECT * FROM users where id = " + id).addScalar("username", StringType.INSTANCE)
				.uniqueResult();
				
		session.close();
		return username;
	}

	@Override
	public String getPassword(long id) {
		
		Session session = DBHandler.getSession();
		String username = (String) session.createSQLQuery("SELECT * FROM users where id = " + id).addScalar("password", StringType.INSTANCE)
				.uniqueResult();
				
		session.close();
		return username;
	}

	@Override
	public List<User> getUserFromCity(String city) {
		
		Session session = DBHandler.getSession();
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) session.createSQLQuery("SELECT * FROM users where city = '" + city +"'").addEntity(User.class).list();
		session.close();
		return users;
	}

	
}
