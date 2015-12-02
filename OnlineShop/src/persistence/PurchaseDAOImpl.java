package persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class PurchaseDAOImpl implements PurchaseDAO {

	private final static String SELECT = "select * from purchases";

	public PurchaseDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Purchase purchase) {
		SessionManager.create(purchase);

	}

	@Override
	public void delete(Purchase purchase) {
		SessionManager.delete(purchase);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> getPurchasesByDate(Date date) {
		Session session = SessionManager.getSession();
		String queryString = "from Purchase where date = :d";
		Query query = session.createQuery(queryString);
		query.setParameter("d", date);
		List<Purchase> purchases = query.list();
		session.close();

		return purchases;
	}

	@Override
	public Date getBestDay() {
		Session session = SessionManager.getSession();
		Query query = session
				.createQuery("select p.date, COUNT(p.id) as c from Purchase p GROUP BY p.date ORDER BY c DESC");

		Date date = (Date) ((Object[]) query.iterate().next())[0];
		session.close();

		return date;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> getPurchase() {
		Session session = SessionManager.getSession();
		List<Purchase> purchases = (List<Purchase>) session.createSQLQuery(SELECT).addEntity(Purchase.class).list();
		session.close();
		return purchases;
	}

}
