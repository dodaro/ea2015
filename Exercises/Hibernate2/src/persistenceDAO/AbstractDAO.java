package persistenceDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDAO implements BasicDAO{
	
	private static SessionFactory factory;
	private static enum Operation {
		CREATE, UPDATE, DELETE
	};
	
	public AbstractDAO() {
		// TODO Auto-generated constructor stub
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

	private static void operation(Object obj, Operation op) {
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
	 
	public void create(Object obj){
		operation(obj, Operation.CREATE);
	}

	public void update(Object obj){
		operation(obj, Operation.UPDATE);
	}
	
	public void delete(Object obj){
		operation(obj, Operation.DELETE);
	}
	
	
}
