package persistence.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.hibernate.Query;
import org.hibernate.Session;

import persistence.dao.interfaces.PurchaseDAOInterface;
import persistence.data.Purchase;
import persistence.handler.DBHandler;

public class PurchaseDAO implements PurchaseDAOInterface{

	@Override
	public void create(Purchase purchase) {
		DBHandler.create(purchase);
	}
	
	@Override
	public void delete(Purchase purchase) {
		DBHandler.delete(purchase);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> getAllPurchases() {

		Session session = DBHandler.getSession();
		List<Purchase> purchases = (List<Purchase>) session.createQuery("from Purchase").list();
		session.close();
		
		return purchases;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> getAllPurchaseInDate(Date date) {

		Session session = DBHandler.getSession();
		
		Query q = session.createQuery("from Purchase where date=:dateTime");
		q.setParameter("dateTime", date);
		
		List<Purchase> purchases = (List<Purchase>) q.list();
		session.close();
		
		return purchases;
	}
	
	
	@Override
	public Long getNumberOfPurchaseInDate(Date date) {

		Session session = DBHandler.getSession();
		Query q = session.createQuery("select count(p) from Purchase p where date=:dateTime");
		q.setParameter("dateTime", date);
		
		Long tot = (Long) q.uniqueResult();
		return tot;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public Date getDateOfMaxPurchase() {

		Session session = DBHandler.getSession();
		Set<Date> dates = new HashSet<Date>(session.createQuery("select date from Purchase").list());
		
		Long max = -1l;
		Date maxDate = null;
		for(Date tmpDate : dates) {
			Long count = getNumberOfPurchaseInDate(tmpDate);
			
			if(count > max) {
				max = count;
				maxDate = tmpDate;
			}
		}
		
		return maxDate;
	}
	
	
}
