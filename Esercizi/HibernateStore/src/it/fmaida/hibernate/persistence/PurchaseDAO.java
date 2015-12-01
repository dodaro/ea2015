package it.fmaida.hibernate.persistence;

import java.util.Date;
import java.util.List;

public interface PurchaseDAO {
	

	public void create(Purchase purchase);
	
	public void delete(Purchase purchase);
	
	public void update(Purchase purchase);
	
	public Purchase getPurchase(int id);
	
	public Long numberOfPurchases();
	
	public List<Purchase> getAllPurchases();
	
	public List<Purchase> getPurchaseInDate(Date date);

}
