package persistence.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DBHandler {

	private static SessionFactory factory;
	private static DBHandler instance;
	private DBHandler(){
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}
	
	public static SessionFactory getFactory(){
		
		if(instance == null){
			instance = new DBHandler();
		}
		
		return factory;
	}
	
}
