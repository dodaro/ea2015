package hibernate.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.persistence.data.Purchase;

public class PurchaseDAO extends AbstractDAO {

	public PurchaseDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public void create(Purchase purchase) {
		performOperation(purchase, Operation.CREATE);
	}

	public void update(Purchase purchase) {
		performOperation(purchase, Operation.UPDATE);
	}

	public void delete(Purchase purchase) {
		performOperation(purchase, Operation.DELETE);
	}

	@SuppressWarnings("unchecked")
	public List<Purchase> getPurchases() {
		Session session = sessionFactory.openSession();
		List<Purchase> purchases = (List<Purchase>) session
				.createSQLQuery("SELECT * FROM purchases").addEntity(Purchase.class).list();
		session.close();
		return purchases;
	}

}
