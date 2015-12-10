package persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import persistence.Person;

public class PersonDAOImpl implements PersonDAO {

	@Override
	public void create(Person p) {
		DBHandler.create(p);
	}

	@Override
	public void delete(Person p) {
		DBHandler.delete(p);
	}
	
	@Override
	public void update(Person p) {
		DBHandler.update(p);
	}

	@Override
	public Person get(Integer id) {
		Session session = DBHandler.getSession();
		String queryString = "from Person where id = :id_person";
		Query query = session.createQuery(queryString);
		query.setParameter("id_person", id);
		Person m = (Person) query.uniqueResult();
		session.close();
		return m;
	}

	@Override
	public Integer numberOfMobileNumbers(Integer id) {
		Session session = DBHandler.getSession();
		String queryString = "from Person where id = :id_person";
		Query query = session.createQuery(queryString);
		query.setParameter("id_person", id);
		Person m = (Person) query.uniqueResult();
		Integer res = m.getMobileNumbers().size();
		session.close();
		return res;
	}

	@Override
	public Integer numberOfAddresses(Integer id) {
		Session session = DBHandler.getSession();
		String queryString = "from Person where id = :id_person";
		Query query = session.createQuery(queryString);
		query.setParameter("id_person", id);
		Person m = (Person) query.uniqueResult();
		Integer res = m.getAddresses().size();
		session.close();
		return res;
	}	
}
