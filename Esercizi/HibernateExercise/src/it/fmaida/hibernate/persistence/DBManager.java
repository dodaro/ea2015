package it.fmaida.hibernate.persistence;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DBManager {
	
	private SessionFactory sessionFactory;
	private static DBManager instance;
	
	public static final int CREATE = 0;
	public static final int UPDATE = 1;
	public static final int DELETE = 2;
	
	
	public static DBManager getInstance() {
		if ( instance == null )
			instance = new DBManager();
		return instance;
	}
	
	private DBManager() {
		initSession();
	}
	
	
	private void initSession() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		instance.sessionFactory = configuration.buildSessionFactory(builder.build());
	}
	
	public SessionFactory getSessionFactory() {
		return instance.sessionFactory;
	}
	
	public Session getSession() {
		return instance.sessionFactory.openSession();
	}
	
	
	public void performOperation(Object obj, int operation) {
		Session session = getSession();		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			switch (operation) {
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
		} catch ( Exception e ) {
			if ( tx != null ) 
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}
