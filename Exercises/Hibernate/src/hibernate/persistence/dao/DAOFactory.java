package hibernate.persistence.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAOFactory {

	private static DAOFactory instance;

	private SessionFactory sessionFactory;

	private DAOFactory() {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	public static DAOFactory get() {
		if (instance == null) {
			instance = new DAOFactory();
		}

		return instance;
	}

	public UserDAO getUserDAO() {
		return new UserDAO(sessionFactory);
	}

	public ProductDAO getProductDAO() {
		return new ProductDAO(sessionFactory);
	}
	
	public PurchaseDAO getPurchaseDAO() {
		return new PurchaseDAO(sessionFactory);
	}
}
