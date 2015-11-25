package persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ProductDAO implements ClassDAO {

	private static final String SELECTBYCODE = "SELECT * FROM products where code = ";
	private static final String SELECTBYNAME = "SELECT * FROM products where name = '";
	private static final String SELECTCOUNT = "SELECT count(*) FROM products";
	private static final String SELECTAVAILABLE = "SELECT * FROM products where available = 1";
	private static final String SELECTCOUNTAVAILABLE = "SELECT count(*) FROM products where available = 1";
	private static final String SELECT = "SELECT * FROM products";
	private static SessionFactory factory;

	public ProductDAO() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}

	@Override
	public void create(Object product) {
		if (product instanceof Product) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(product);
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				throw e;
			} finally {
				session.close();
			}
		}
	}

	@Override
	public Object getById(Integer code) {
		Session session = factory.openSession();
		Product product = (Product) session.createSQLQuery(SELECTBYCODE + code).addEntity(Product.class).uniqueResult();
		session.close();
		return product;
	}

	@Override
	public Object getByUsername(String name) {
		Session session = factory.openSession();
		Product product = (Product) session.createSQLQuery(SELECTBYNAME + name + "'").addEntity(Product.class)
				.uniqueResult();
		session.close();
		return product;
	}

	@Override
	public void update(Object product) {
		if (product instanceof Product) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.update(product);
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				throw e;
			} finally {
				session.close();
			}
		}

	}

	@Override
	public void delete(Object product) {
		if (product instanceof Product) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.delete(product);
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				throw e;
			} finally {
				session.close();
			}
		}

	}

	@Override
	public int numberOfTuple() {
		Session session = factory.openSession();
		int size = (int) session.createSQLQuery(SELECTCOUNT).uniqueResult();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getTuples() {
		Session session = factory.openSession();
		List<Product> products = (List<Product>) session.createSQLQuery(SELECT).addEntity(Product.class).list();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAvailable() {
		Session session = factory.openSession();
		List<Product> products = (List<Product>) session.createSQLQuery(SELECTAVAILABLE).addEntity(Product.class)
				.list();
		session.close();
		return products;
	}
	
	public int getAvailableNumber(){
		Session session = factory.openSession();
		int size = (int) session.createSQLQuery(SELECT).list().size();
		session.close();
		return size;
	}
}
