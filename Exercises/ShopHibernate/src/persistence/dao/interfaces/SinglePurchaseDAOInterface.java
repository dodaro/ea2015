package persistence.dao.interfaces;

import java.util.List;

import persistence.data.SinglePurchase;

public interface SinglePurchaseDAOInterface {

	public void create(SinglePurchase singlePurchase);
	public void delete(SinglePurchase singlePurchase);
	
	public List<SinglePurchase> getAllSinglePurchase();
	
}
