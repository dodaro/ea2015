package persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DBHandler {

	private static SessionFactory factory;
	
	private static enum Operation {
		CREATE, UPDATE, DELETE
	};

	public DBHandler() {
		factory = null;
	}
	
	private static void performOperation(Object obj, Operation op) {
		Session session = getSession();
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
			throw e;
		} finally {
			session.close();
		}
	}
	
	public static void create(Object obj) {
		performOperation(obj, Operation.CREATE);
	}
	
	public static void delete(Object obj) {
		performOperation(obj, Operation.DELETE);
	}
	
	public static void update(Object obj) {
		performOperation(obj, Operation.UPDATE);
	}
	
	private static void createSessionFactory() {
		if (factory != null)
			return;

		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}
	
	public static Session getSession() {
		if (factory == null)
			createSessionFactory();
		return factory.openSession();
	}
}
