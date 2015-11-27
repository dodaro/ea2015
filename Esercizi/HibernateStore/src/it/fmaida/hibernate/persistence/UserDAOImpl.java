package it.fmaida.hibernate.persistence;

import java.math.BigInteger;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class UserDAOImpl implements UserDAO {

	private DBManager dbManager;
	
	public UserDAOImpl() {
		this.dbManager = DBManager.getInstance();
	}
	
	@Override
	public void createUser(User user) {
		this.dbManager.performOperation(user, DBManager.CREATE);
	}

	@Override
	public User get(Integer id) {
		Session session = dbManager.getSession();
		User user = (User) session.createSQLQuery("SELECT * from Users where id = " + id).addEntity(User.class).uniqueResult();
		session.close();
		return user;
	}

	@Override
	public User get(String username) {
		Session session = dbManager.getSession();
		User user = (User) session.createSQLQuery("SELECT * from Users where username = '" + username + "'").addEntity(User.class).uniqueResult();
		if ( user != null ) {
			user.getPurchases().size();
			for ( Purchase curr : user.getPurchases() ) {
				System.out.println("here");
				curr.getItems().size();
			}
		}
		session.close();
		return user;
	}

	@Override
	public void update(User user) {
		this.dbManager.performOperation(user, DBManager.UPDATE);
	}

	@Override
	public void delete(User user) {
		this.dbManager.performOperation(user, DBManager.DELETE);
	}

	@Override
	public int numberOfUsers() {
		Session session = dbManager.getSession();
		BigInteger n  = (BigInteger) session.createSQLQuery("SELECT count(*) from users").uniqueResult();
		session.close();
		return n.intValue();
	}

	@Override
	public List<User> getUsers() {
		Session session = dbManager.getSession();
		List<User> users = session.createSQLQuery("SELECT * FROM users").addEntity(User.class).list();
		session.close();
		return users;
	}

}
