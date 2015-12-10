package persistence;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class PurchaseDAOImpl implements PurchaseDAO {

	@Override
	public void create(Purchase p) {
		DBHandler.create(p);
	}
	
	@Override
	public void delete(Purchase p) {
		DBHandler.delete(p);
	}

	@Override
	public Purchase get(Integer id) {
		Session session = DBHandler.getSession();
		String queryString = "from Purchase where id = :id_purchase";
		Query query = session.createQuery(queryString);
		query.setParameter("id_purchase", id);
		Purchase p = (Purchase) query.uniqueResult();
//		p.getUsers().size(); //trucco per non scorrere la lista
		session.close();
		return p;
	}

	@Override
	public int numberOfPurchasesForDate(Date d) {
		Session session = DBHandler.getSession();
		String queryString = "select count(*) from Purchase where date = :datelocal";
		Query query = session.createQuery(queryString);
		query.setParameter("datelocal", d);
		int count = ((Long) query.uniqueResult()).intValue();
		session.close();
		return count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Date dayOfMaxPurchases() {
		Session session = DBHandler.getSession();
		Query query = session.createQuery("select count(*), p.date " +
				"from Purchase p group by p.date order by count(*) desc");;
		List<Object[]> res = query.list();
		Date data = (Date)res.get(0)[1]; 
		session.close();
		return data;
	}
}
