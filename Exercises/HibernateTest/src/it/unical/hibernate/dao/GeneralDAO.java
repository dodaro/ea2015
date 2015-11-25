package it.unical.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public abstract class GeneralDAO {

	protected static SessionFactory factory;
	
	
	public GeneralDAO() {
		
		Configuration configuration = new Configuration().configure();
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		GeneralDAO.factory = configuration.buildSessionFactory(builder.build());
	}
	
	abstract public void create(Object obj);
	abstract public void update(Object obj);
	abstract public void delete(Object obj);
	
}
