package it.unical.hibernate.dao.concrete;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unical.hibernate.dao.GeneralDAO;
import it.unical.hibernate.data.Shop;

public class ShopDAO extends GeneralDAO {


	@Override
	public void create(Object obj) {
		Shop shop = (Shop) obj;
		
		Session session = GeneralDAO.factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(shop);
			transaction.commit();
			
		} catch (Exception e) {

			if(transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
		finally {
			
			session.close();
		}
	}
	
	@Override
	public void update(Object obj) {
		Shop shop = (Shop) obj;
		
		Session session = GeneralDAO.factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.update(shop);
			transaction.commit();
			
		} catch (Exception e) {

			if(transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
		finally {
			
			session.close();
		}
	}
	
	@Override
	public void delete(Object obj) {
		Shop shop = (Shop) obj;
		
		Session session = GeneralDAO.factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.delete(shop);
			transaction.commit();
			
		} catch (Exception e) {

			if(transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
		finally {
			
			session.close();
		}
	}
	
	
	//TODO add more get or query functions
	
	
}
