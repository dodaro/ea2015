package persistence.dao;

import java.util.List;

import org.hibernate.Session;

import persistence.dao.interfaces.SinglePurchaseDAOInterface;
import persistence.data.SinglePurchase;
import persistence.handler.DBHandler;

public class SinglePurchaseDAO implements SinglePurchaseDAOInterface {

	@Override
	public void create(SinglePurchase singlePurchase) {
		DBHandler.create(singlePurchase);
	}

	@Override
	public void delete(SinglePurchase singlePurchase) {
		DBHandler.delete(singlePurchase);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SinglePurchase> getAllSinglePurchase() {
		
		Session session = DBHandler.getSession();
		List<SinglePurchase> singlePurchases = (List<SinglePurchase>) session.createQuery("from SinglePurchase").list();
		session.close();
		
		return singlePurchases;
	}

}
