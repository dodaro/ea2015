package persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import persistence.Member;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public void create(Member m) {
		DBHandler.create(m); 
	}
	
	@Override
	public void update(Member m) {
		DBHandler.update(m);
	}

	@Override
	public void delete(Member m) {
		DBHandler.delete(m);
	}

	@Override
	public Member get(Integer id) {
		Session session = DBHandler.getSession();
		String queryString = "from Member where id = :id_member";
		Query query = session.createQuery(queryString);
		query.setParameter("id_member", id);
		Member m = (Member) query.uniqueResult();	
		session.close();	
	    return m;
	}	

	@Override
	public Double sumOfSalary() {
		Session session = DBHandler.getSession();
		String queryString = "select sum(salary) from Professor";
		Query query = session.createQuery(queryString);
		Double d = (Double) query.uniqueResult();	
		session.close();	
	    return d;
	}

	@Override
	public Double maxOfAvgScore() {
		Session session = DBHandler.getSession();
		String queryString = "select max(avgScore) from Student";
		Query query = session.createQuery(queryString);
		Double d = (Double) query.uniqueResult();	
		session.close();	
	    return d;
	}	
}
