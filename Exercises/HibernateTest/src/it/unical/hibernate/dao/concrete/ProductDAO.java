package it.unical.hibernate.dao.concrete;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unical.hibernate.dao.GeneralDAO;
import it.unical.hibernate.data.Product;

public class ProductDAO extends GeneralDAO{

	
	@Override
	public void create(Object obj) {
		Product product = (Product) obj;
		
		Session session = GeneralDAO.factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(product);
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
		Product product = (Product) obj;
		
		Session session = GeneralDAO.factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.update(product);
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
		Product product = (Product) obj;
		
		Session session = GeneralDAO.factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.delete(product);
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
	
	
	
	
}
