package persistenceDAO;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import persistenceDTO.Purchase;
import persistenceDTO.User;


public class UserDAOConc extends AbstractDAO {

	public UserDAOConc() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void createUser(User user) {
		create(user);
		//observer invoke
	}

	
	public void updateUser(User user) {
		update(user);
		//observer invoke
	}

	
	public void deleteUser(User user) {
		delete(user);
		//observer invoke
	}	


	public User get(Integer id) {
		Session session = getSession();
		
		String queryString = "from User where id = :id_user";
		Query query = session.createQuery(queryString);
		query.setParameter("id_user", id);
		User user = (User) query.uniqueResult();
		
		if (user != null) {
		for (Purchase p : user.getPurchase()) {
				 Hibernate.initialize(p);
		 	}
		}
		session.close();
		return user;
	}

	public User get(String username) {
		Session session = getSession();
		
		String queryString = "from User where username = :username_user";
		Query query = session.createQuery(queryString);
		query.setParameter("username_user", username);
		User user = (User) query.uniqueResult();
	
		if (user != null) {
			for (Purchase p : user.getPurchase()) {
				 Hibernate.initialize(p);
			}
		}
		
		session.close();
		return user;
	}
	
	
	public int numberOfUsers() {
		Session session = getSession();
		
		String queryString = "from User";
		Query query = session.createQuery(queryString);
		int size = query.list().size();

		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Session session = getSession();
		
		String queryString = "from User";
		Query query = session.createQuery(queryString);
		List<User> users = (List<User>) query.list();

		if(users!=null){
			for (User user : users) {
				user.getPurchase().size();
			}
		}

		
		session.close();
		return users;
	}
}
