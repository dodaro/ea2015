package it.unical.carseller.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import it.unical.carseller.model.Color;
import it.unical.carseller.model.DBHandler;
import it.unical.carseller.model.CarModel;

public class CarDaoImpl implements CarDao {

	private DBHandler dbHandler;
	
	public DBHandler getDbHandler() {
		return dbHandler;
	}

	public void setDbHandler(DBHandler dbHandler) {
		this.dbHandler = dbHandler;
	}
	
	@Override
	public void create(CarModel m) {
		dbHandler.create(m);
	}

	@Override
	public void update(CarModel m) {
		dbHandler.update(m);
	}

	@Override
	public void delete(CarModel m) {
		dbHandler.delete(m);
	}

	@Override
	public void create(Color c) {
		dbHandler.create(c);
	}

	@Override
	public void update(Color c) {
		dbHandler.update(c);
	}

	@Override
	public void delete(Color c) {
		dbHandler.delete(c);
	}
	
	@Override
	public CarModel getCarModel(String name) {
		Session session = dbHandler.getSessionFactory().openSession();
		String queryString = "from CarModel where name = :name";
		Query query = session.createQuery(queryString);
		query.setParameter("name", name);
		CarModel m = (CarModel) query.uniqueResult();	
		session.close();	
	    return m;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CarModel> getAllCarModels() {
		Session session = dbHandler.getSessionFactory().openSession();
		String queryString = "from CarModel m order by m.price";
		Query query = session.createQuery(queryString);
		List<CarModel> models = (List<CarModel>) query.list();	
		session.close();	
	    return models;
	}
	
	@Override
	public Color getColor(String name) {
		Session session = dbHandler.getSessionFactory().openSession();
		String queryString = "from Color where name = :name";
		Query query = session.createQuery(queryString);
		query.setParameter("name", name);
		Color c = (Color) query.uniqueResult();	
		session.close();	
	    return c;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Color> getAllColors() {
		Session session = dbHandler.getSessionFactory().openSession();
		String queryString = "from Color c order by c.price";
		Query query = session.createQuery(queryString);
		List<Color> cols = (List<Color>) query.list();	
		session.close();	
	    return cols;
	}
}
