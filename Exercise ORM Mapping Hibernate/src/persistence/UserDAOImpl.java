package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAOImpl implements UserDAO {

	public UserDAOImpl() {}

	public void create(User user) throws Exception {
		DBManager.create(user);
	}	

	public void update(User user) throws Exception {
		DBManager.update(user);
	}	

	public void delete(User user) throws Exception {
		DBManager.delete(user);
	}


	public int numberOfUsers() {
		Session session = DBManager.getSession();
		int size = session.createSQLQuery("SELECT * FROM users").list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Session session = DBManager.getSession();
		List<User> users = (List<User>) session.createSQLQuery("SELECT * FROM users").addEntity(User.class).list();
		session.close();
		return users;
	}

	public User get(Integer id) {
		//		Session session = DBManager.getSession();
		//		User user = (User) session.createSQLQuery("SELECT * FROM users where id = " + id).addEntity(User.class).uniqueResult();
		//		session.close();
		Session session = DBManager.getSession();
		String queryString = "from users where id = :id_user";
		Query query = session.createQuery(queryString);
		query.setParameter("id_user", id);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}

	public User get(String username) {
		//		Session session = DBManager.getSession();
		//		User user = (User) session.createSQLQuery("SELECT * FROM users where username = '" + username + "'").addEntity(User.class).uniqueResult();
		//		session.close();
		Session session = DBManager.getSession();
		String queryString = "from users where username = :username_user";
		Query query = session.createQuery(queryString);
		query.setParameter("username_user", username);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}	
}
