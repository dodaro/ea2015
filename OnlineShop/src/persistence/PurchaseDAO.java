package persistence;

import java.util.Date;
import java.util.List;

public interface PurchaseDAO {

	
	
	public void create(Purchase purchase);
	
	public void delete(Purchase purchase);

	public List<Purchase> getPurchase();
	
	public List<Purchase> getPurchasesByDate(Date date);
	
	public Date getBestDay();


}
