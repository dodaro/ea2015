package it.fmaida.hibernate.persistence;

import org.hibernate.Session;

public class ItemPurchaseDAOImpl implements ItemPurchaseDAO {

	private DBManager dbManager;
	
	public ItemPurchaseDAOImpl() {
		this.dbManager = DBManager.getInstance();
	}
	
	@Override
	public void create(ItemPurchase itemPurchase) {
		Session session = this.dbManager.getSession();
		dbManager.performOperation(itemPurchase, DBManager.CREATE);
		session.close();
	}

	@Override
	public void delete(ItemPurchase itemPurchase) {
		Session session = this.dbManager.getSession();
		dbManager.performOperation(itemPurchase, DBManager.DELETE);
		session.close();
	}

	@Override
	public void update(ItemPurchase itemPurchase) {
		Session session = this.dbManager.getSession();
		dbManager.performOperation(itemPurchase, DBManager.UPDATE);
		session.close();
	}

}
