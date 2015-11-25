package it.unical.hibernate.dao.concrete;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unical.hibernate.dao.GeneralDAO;
import it.unical.hibernate.data.User;

public class UserDAO extends GeneralDAO {

	@Override
	public void create(Object obj) {
		User user = (User) obj;
		
		Session session = GeneralDAO.factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			
		} catch (Exception e) {

			if(transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
		finally {
			
			session.close();
		}
	}
	
	@Override
	public void update(Object obj) {
		User user = (User) obj;
		
		Session session = GeneralDAO.factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			
		} catch (Exception e) {

			if(transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
		finally {
			
			session.close();
		}
	}
	
	@Override
	public void delete(Object obj) {
		User user = (User) obj;
		
		Session session = GeneralDAO.factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
			
		} catch (Exception e) {

			if(transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
		finally {
			
			session.close();
		}
	}
	
	
	public User get(int id) {
		
		Session session = null;
		User tmpUser = null;
		
		try {
			session = GeneralDAO.factory.openSession();
			
			tmpUser = (User) session.createSQLQuery("SELECT * FROM users WHERE id = " + id)
					.addEntity(User.class).uniqueResult();
		} catch (Exception e) {

			session.close();
		}
		
		return tmpUser;
	}
	
	

	public User get(String username) {
		
		Session session = null;
		User tmpUser = null;
		
		try {
			session = GeneralDAO.factory.openSession();
			
			tmpUser = (User) session.createSQLQuery("SELECT * FROM users WHERE username = '" + username + "'")
					.addEntity(User.class).uniqueResult();
		} catch (Exception e) {

			session.close();
		}
		
		return tmpUser;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<User> getUsersWithAge(int i) {
		
		Session session = null;
		List<User> tmpUsers = new ArrayList<>();
		
		try {
			session = GeneralDAO.factory.openSession();
			
			tmpUsers = (List<User>) session.createSQLQuery("SELECT * FROM users WHERE age = " + i)
					.addEntity(User.class).list();
		} catch (Exception e) {

			session.close();
		}
		
		return tmpUsers;
	}
		
}
