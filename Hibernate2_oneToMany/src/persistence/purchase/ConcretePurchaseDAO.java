package persistence.purchase;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import persistence.product.Product;
import persistence.user.ConcreteUserDAO;
import persistence.user.User;
import persistence.user.UserDAO;
import persistence.utils.DBHandler;


public class ConcretePurchaseDAO implements PurchaseDAO{


	public ConcretePurchaseDAO() {
	}

	@Override
	public Purchase find(long id) {

		Session session = DBHandler.getSession();
		Purchase purchases = (Purchase) session.createSQLQuery("SELECT * FROM purchases where id = " + id).addEntity(Purchase.class)
				.uniqueResult();
		session.close();
		return purchases;
	}

	@Override
	public List<Purchase> getPurchases() {

		Session session = DBHandler.getSession();
		@SuppressWarnings("unchecked")
		List<Purchase> purchases = (List<Purchase>) session.createSQLQuery("SELECT * FROM purchases").addEntity(Purchase.class).list();
		session.close();
		return purchases;
	}

	@Override
	public List<Product> getProductsOfUser(User user) {

		Session session = DBHandler.getSession();
		String queryString = "select p.products from Purchase p where p.user = :user";
		Query query = session.createQuery(queryString);
		query.setParameter("user", user);
		
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) query.list();
		session.close();
		
		return products;
	}

	@Override
	public List<Purchase> getPurchaseByDate(Date date) {
		
		Session session = DBHandler.getSession();
		String queryString = "from Purchase p where p.date = :date";
		Query query = session.createQuery(queryString);
		query.setParameter("date", date);
		
		@SuppressWarnings("unchecked")
		List<Purchase> purchases = (List<Purchase>) query.list();
		session.close();
		
		return purchases;
	}

	@Override
	public Date getDateMaxNumSales() {
		
		Session session = DBHandler.getSession();
		String queryString = "select p.date from Purchase p where p.products.size = (select max(p2.products.size) from Purchase p2)";
		Query query = session.createQuery(queryString);
		
		Date date = (Date) (query.uniqueResult());
		session.close();
		
		return date;
		
	}



}
