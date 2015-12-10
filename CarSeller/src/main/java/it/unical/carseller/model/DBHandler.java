package it.unical.carseller.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DBHandler {

	private SessionFactory sessionFactory;
	
	private static enum Operation {
		CREATE, UPDATE, DELETE
	};

	public DBHandler() {
		sessionFactory = null;
	}
	
	private void performOperation(Object obj, Operation op) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			switch (op) {
			case CREATE:
				session.save(obj);
				break;
			case UPDATE:
				session.update(obj);
				break;
			case DELETE:
				session.delete(obj);
				break;
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();			
		} finally {
			session.close();
		}
	}
	
	public void create(Object obj) {
		performOperation(obj, Operation.CREATE);
	}
	
	public void delete(Object obj) {
		performOperation(obj, Operation.DELETE);
	}
	
	public void update(Object obj) {
		performOperation(obj, Operation.UPDATE);
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
