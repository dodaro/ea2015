package DAOImplementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import DAOInterfaces.ClientDAOInterface;
import persistence.Client;

public class ClientDAOImplementation implements ClientDAOInterface
{
	private static SessionFactory factory;

	public ClientDAOImplementation()
	{
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}

	@Override
	public void create(Client client)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(client);
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
	public Client get(Integer id)
	{
		Session session = factory.openSession();
		Client client = (Client) session.createSQLQuery("SELECT * FROM clients where id = " + id)
				.addEntity(Client.class).uniqueResult();
		session.close();
		return client;
	}

	@Override
	public void update(Client client)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.update(client);
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
	public void delete(Client client)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.delete(client);
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
	public int numberOfClients()
	{
		Session session = factory.openSession();
		int size = session.createSQLQuery("SELECT * FROM clients").list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClients()
	{
		Session session = factory.openSession();
		List<Client> client = (List<Client>) session.createSQLQuery("SELECT * FROM clients").addEntity(Client.class).list();
		session.close();
		return client;
	}
}