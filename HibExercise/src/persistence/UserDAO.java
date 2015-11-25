package persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UserDAO implements ClassDAO {
	private static final String SELECTBYID = "SELECT * FROM users where id = ";
	private static final String SELECTBYUSRNAME = "SELECT * FROM users where username = '";
	private static final String SELECTCOUNT = "SELECT count(*) FROM users";
	private static final String SELECT = "SELECT * FROM users";
	private static SessionFactory factory;

	public UserDAO() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}

	@Override
	public void create(Object user) {
		if (user instanceof User) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(user);
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
	public Object getById(Integer id) {
		Session session = factory.openSession();
		User user = (User) session.createSQLQuery(SELECTBYID + id).addEntity(User.class).uniqueResult();
		session.close();
		return user;
	}

	@Override
	public Object getByUsername(String username) {
		Session session = factory.openSession();
		User user = (User) session.createSQLQuery(SELECTBYUSRNAME + username + "'").addEntity(User.class)
				.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public void update(Object user) {
		if (user instanceof User) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.update(user);
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
	public void delete(Object user) {
		if (user instanceof User) {
			Session session = factory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.delete(user);
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
		int size = (int) session.createSQLQuery(SELECT).list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	public List<User> getTuples() {
		Session session = factory.openSession();
		List<User> users = (List<User>) session.createSQLQuery(SELECT).addEntity(User.class).list();
		session.close();
		return users;
	}

}
