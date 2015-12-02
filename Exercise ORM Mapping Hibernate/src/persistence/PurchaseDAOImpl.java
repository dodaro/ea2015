package persistence;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

public class PurchaseDAOImpl implements PurchaseDAO {

	public PurchaseDAOImpl() {}
	
	public void create(Purchase purchase) throws Exception {
		DBManager.create(purchase);
	}	
	
	public void delete(Purchase purchase) throws Exception {
		DBManager.delete(purchase);
	}
	
	public int numberOfPurchases() {
		Session session = DBManager.getSession();
		int size = session.createSQLQuery("SELECT * FROM purchases").list().size();
		session.close();
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public List<Purchase> getPurchases() {
		Session session = DBManager.getSession();
		List<Purchase> purchases = (List<Purchase>) session.createSQLQuery("SELECT * FROM purchases").addEntity(Purchase.class).list();
		session.close();
		return purchases;
	}
	
	public Purchase get(Integer id) {
		//		Session session = DBManager.getSession();
		//		Purchase purchase = (Purchase) session.createSQLQuery("SELECT * FROM purchases where id = " + id).addEntity(Purchase.class).uniqueResult();
		//		session.close();
		Session session = DBManager.getSession();
		String queryString = "from purchases where id = :id_purchase";
		Query query = session.createQuery(queryString);
		query.setParameter("id_purchase", id);
		Purchase purchase = (Purchase) query.uniqueResult();
		session.close();
		return purchase;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductBoughtByUser(User user) {
		//		Session session = DBManager.getSession();
		//		List<Product> products = (List<Product>) session.createQuery("from purchases p where p.user = " + user).list();
		//		session.close();
		Session session = DBManager.getSession();
		String queryString = "from purchases p where p.user = :user_purchase";
		Query query = session.createQuery(queryString);
		query.setParameter("user_purchase", user);
		List<Product> products = (List<Product>) query.uniqueResult();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	public List<Purchase> getPurchasesInDate(Date date) {
		//		Session session = DBManager.getSession();
		//		List<Purchase> purchases = (List<Purchase>) session.createQuery("from purchases p where p.date = " + date).list();
		//		session.close();
		Session session = DBManager.getSession();
		String queryString = "from purchases p where p.date = :date_purchase";
		Query query = session.createQuery(queryString);
		query.setParameter("date_purchase", date);
		List<Purchase> purchases = (List<Purchase>) query.uniqueResult();
		session.close();
		return purchases;
	}

	@SuppressWarnings("unchecked")
	public Date getDateWithGreaterNumberOfPurchases() {
		Session session = DBManager.getSession();
		Set<Date> dateList = new HashSet<Date>(session.createQuery("select date from purchase").list());
		
		int max = 0;
		Date maxDate = null;
		for(Date currentDate : dateList) {
			int count = getPurchasesInDate(currentDate).size();
			
			if(count > max) {
				max = count;
				maxDate = currentDate;
			}
		}
		
		return maxDate;
	}	
}
