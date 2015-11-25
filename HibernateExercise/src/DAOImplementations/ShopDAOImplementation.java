package DAOImplementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import DAOInterfaces.ShopDAOInterface;
import persistence.Client;
import persistence.Shop;

public class ShopDAOImplementation implements ShopDAOInterface
{
	private static SessionFactory factory;
	
	public ShopDAOImplementation()
	{
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}

	@Override
	public void create(Shop shop)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(shop);
			tx.commit();
		}
		catch (Exception e)
		{
			if (tx != null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public Shop get(Integer id)
	{
		Session session = factory.openSession();
		Shop shop = (Shop) session.createSQLQuery("SELECT * FROM shops where id = " + id).addEntity(Shop.class).uniqueResult();
		session.close();
		return shop;
	}

	@Override
	public Shop get(String partitaIVA)
	{
		Session session = factory.openSession();
		Shop shop = (Shop) session.createSQLQuery("SELECT * FROM shops where partitaIVA = '" + partitaIVA + "'").addEntity(Shop.class).uniqueResult();
		session.close();
		return shop;
	}

	@Override
	public void update(Shop shop)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.update(shop);
			tx.commit();
		}
		catch (Exception e)
		{
			if (tx != null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public void delete(Shop shop)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.delete(shop);
			tx.commit();
		}
		catch (Exception e)
		{
			if (tx != null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public int numberOfShops()
	{
		Session session = factory.openSession();
		int size = session.createSQLQuery("SELECT * FROM shops").list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShops()
	{
		Session session = factory.openSession();
		List<Shop> shop = (List<Shop>) session.createSQLQuery("SELECT * FROM shops").addEntity(Shop.class).list();
		session.close();
		return shop;
	}

}
