package it.fmaida.hibernate.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class PurchaseDAOImpl implements PurchaseDAO {

	private DBManager dbManager;
	
	public PurchaseDAOImpl() {
		this.dbManager = DBManager.getInstance();
	}
	
	@Override
	public void create(Purchase purchase) {
		dbManager.performOperation(purchase, DBManager.CREATE);
	}

	@Override
	public void delete(Purchase purchase) {
		dbManager.performOperation(purchase, DBManager.DELETE);
	}

	@Override
	public void update(Purchase purchase) {
		dbManager.performOperation(purchase, DBManager.UPDATE);
	}

	@Override
	public Purchase getPurchase(int id) {
		Session session = dbManager.getSession();
		String queryString = "from Purchases where id = :id";
		Query query = session.createQuery(queryString);
		query.setParameter("id",id);
		Purchase purchase = (Purchase) query.uniqueResult();
		session.close();
		return purchase;
	}

	@Override
	public Long numberOfPurchases() {
		Session session = dbManager.getSession();
		Long size = (Long) session.createQuery("select count(*) from Purchases").uniqueResult();
		session.close();
		return size;
	}

	@Override
	public List<Purchase> getAllPurchases() {
		Session session = dbManager.getSession();
		ArrayList<Purchase> purchases = (ArrayList<Purchase>) session.createQuery("from Purchase").list();
		session.close();
		return purchases;
	}

	@Override
	public List<Purchase> getPurchaseInDate(Date date) {
		Session session = dbManager.getSession();
		String queryString = "FROM Purchase p where p.purchaseDate = :purchase_date";
		Query query = session.createQuery(queryString);
		query.setParameter("purchase_date", date);
		ArrayList<Purchase> purchases = (ArrayList<Purchase>) query.list();
		session.close();
		return purchases;
	}

}
