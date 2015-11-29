package persistence.dao.interfaces;

import java.util.Date;
import java.util.List;

import persistence.data.Purchase;

public interface PurchaseDAOInterface {

	public void create(Purchase purchase);
	public void delete(Purchase purchase);
	
	public List<Purchase> getAllPurchases();
	public List<Purchase> getAllPurchaseInDate(Date date);
	public Long getNumberOfPurchaseInDate(Date date);
	
	public Date getDateOfMaxPurchase();
	
}
