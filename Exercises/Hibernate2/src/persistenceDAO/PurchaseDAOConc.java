package persistenceDAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import persistenceDTO.Purchase;
import persistenceDTO.User;

public class PurchaseDAOConc extends AbstractDAO{
	
	public PurchaseDAOConc() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void createPurchase(Purchase purchase) {
		create(purchase);
		//observer invoke
	}

	
	public void updatePurchase(Purchase purchase) {
		update(purchase);
		//observer invoke
	}

	
	public void deletePurchase(Purchase purchase) {
		delete(purchase);
		//observer invoke
	}	

	public Purchase get(Integer id) {
		Session session = getSession();
		
		String queryString = "from Purchase where id = :id_purchase";
		Query query = session.createQuery(queryString);
		query.setParameter("id_purchase", id);
		Purchase purc = (Purchase) query.uniqueResult();
		
		session.close();
		return purc;
	}
	
	@SuppressWarnings("unchecked")
	public List<Purchase> getPurchases(){
		Session session = getSession();
		
		String queryString = "from Purchase";
		Query query = session.createQuery(queryString);
		List<Purchase> purchases=(List<Purchase>)query.list();
		
		session.close();
		return purchases;
	}
	
	@SuppressWarnings("unchecked")
	public List<Purchase> getPurchasesForUser(User u){
		Session session = getSession();
		
		String queryString = "from Purchase where user = :user_purchase";
		Query query = session.createQuery(queryString);
		query.setParameter("user_purchase", u);
		List<Purchase> purchases=(List<Purchase>)query.list();
		
		/* 
		 * DOMANDA PER IL PROF:
		 * 
		 * Perchè questa soluzione qui sotto non lavora? il campo user nella tabella non è l'id dell'utente?o lo mappa in maniera diversa?
		 * List<Purchase> purchases = (List<Purchase>) session.createSQLQuery("SELECT * FROM purchase where user = "+u.getId())
				.addEntity(Purchase.class).list();*/	
		
		session.close();
		return purchases;
	}
	
	@SuppressWarnings("unchecked")
	public List<Purchase> getPurchasesForDate(Date d){
		Session session = getSession();
		
		String queryString = "from Purchase where date = :data_purchase";
		Query query = session.createQuery(queryString);
		query.setParameter("data_purchase", d);
		List<Purchase> purchases=(List<Purchase>)query.list();
		
		session.close();
		return purchases;
	}
	
	@SuppressWarnings("unchecked")
	public Date getGreatestDate(){
		Session session = getSession();
		
		String queryString ="select count(p.date) from Purchase p group by p.date"; //"select date,count(*) as c1 from Purchase p1 where not exists (select date, count(*) as c2 from Purchase p2 groupby date and p1.date <= p2.date and d1!=d2)";
		Query query = session.createQuery(queryString);
		List<Long> cardinalities=query.list();
		long max=0;
		for (Long integer : cardinalities) {
			if(integer>max)
				max=integer.intValue();
		}
		
		queryString ="select p.date from Purchase p group by p.date having count(p.date) = :c_max";
		Query query2 = session.createQuery(queryString);
		query2.setParameter("c_max", max);
		Date date=(Date) query2.uniqueResult();
		session.close();
		return date;
	}
	//6. Get the list of all products bought by a user.
	//7. Get all the purchase of a specific date.
	//8. Get the date on which they were made the greatest number of purchases.
	
}
