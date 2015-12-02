package DAOImplementations;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import DAOIntefaces.PurchaseDAO;
import persistence.DBHandler;
import persistence.Purchase;
import persistence.User;

public class PurchaseDAOImpl implements PurchaseDAO
{
	public PurchaseDAOImpl()
	{}

	@Override
	public void create(Purchase purchase)
	{
		DBHandler.create(purchase);
	}

	@Override
	public Purchase get(Integer id)
	{
		Session session = DBHandler.getSession();
		Purchase purchase = (Purchase) session.createSQLQuery("SELECT * FROM purchases where id = " + id).addEntity(Purchase.class).uniqueResult();
		session.close();
		return purchase;
	}

	@Override
	public void delete(Purchase purchase)
	{
		DBHandler.delete(purchase);
	}

	@Override
	public int numberOfPurchases()
	{
		Session session = DBHandler.getSession();
		int size = session.createSQLQuery("SELECT * FROM purchases").list().size();
		session.close();
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> getPurchases(User user)
	{
		Session session = DBHandler.getSession();
		List<Purchase> purchases = (List<Purchase>) session.createSQLQuery("SELECT * FROM purchases WHERE id_user = " + user.getId()).addEntity(Purchase.class).list();
		session.close();
		return purchases;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purchase> getPurchases(Date date)
	{
		Session session = DBHandler.getSession();
		List<Purchase> purchases = (List<Purchase>) session.createSQLQuery("SELECT * FROM purchases where date = '2015-12-25'").addEntity(Purchase.class).list();
		session.close();
		return purchases;
	}

	@Override
	public Date getDateWithGreatestNumberOfPurchase()
	{
		Session session = DBHandler.getSession();
		Date date = (Date) session.createSQLQuery("SELECT date "
												+ "FROM purchases "
												+ "GROUP BY date "
												+ "HAVING COUNT(*) = ( SELECT MAX(c) "
																	+ "FROM (  SELECT COUNT(*) c "
																			+ "FROM purchases "
																			+ "GROUP BY date))")
				.uniqueResult();
		session.close();
		return date;
	}

}
