package it.fmaida.hibernate.persistence;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ShopDAOImpl implements ShopDAO {

	private DBManager dbManager;
	
	public ShopDAOImpl() {
		this.dbManager = DBManager.getInstance();
	}
	
	@Override
	public void create(Shop shop) {
		this.dbManager.performOperation(shop, DBManager.CREATE);
	}

	@Override
	public void delete(Shop shop) {
		this.dbManager.performOperation(shop, DBManager.DELETE);
	}

	@Override
	public void update(Shop shop) {
		this.dbManager.performOperation(shop, DBManager.UPDATE);
	}

	@Override
	public Shop getShop(int id) {
		Session session = dbManager.getSession();
		Shop shop = (Shop) session.createSQLQuery("SELECT * FROM shops where id = '" + id + "'" ).addEntity(Shop.class).uniqueResult();
		session.close();
		return shop;
	}


	@Override
	public List<Shop> getShopsByCity(String city) {
		Session session = dbManager.getSession();
		List<Shop> shops = session.createSQLQuery("SELECT * FROM shops where city = '" + city + "'").addEntity(Shop.class).list();
		session.close();
		return shops;
	}

	@Override
	public List<Shop> getShops() {
		Session session = dbManager.getSession();
		List<Shop> shops = session.createSQLQuery("SELECT * FROM shops").addEntity(Shop.class).list();
		session.close();
		return shops;
	}

	@Override
	public int numberOfShops() {
		Session session = dbManager.getSession();
		BigInteger n = (BigInteger) session.createSQLQuery("SELECT count(*) FROM shops").uniqueResult();
		session.close();
		return n.intValue();
	}

}
