package hibernate.tests;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import hibernate.persistence.dao.DAOFactory;
import hibernate.persistence.dao.ProductDAO;
import hibernate.persistence.dao.PurchaseDAO;
import hibernate.persistence.dao.UserDAO;
import hibernate.persistence.data.Product;
import hibernate.persistence.data.Purchase;
import hibernate.persistence.data.User;

public class Tests {

	@BeforeClass
	static public void initDB() {
		UserDAO userDao = DAOFactory.get().getUserDAO();
		ProductDAO productDAO = DAOFactory.get().getProductDAO();
		PurchaseDAO purchaseDAO = DAOFactory.get().getPurchaseDAO();

		for (int i = 1; i <= 100; i++) {
			User user = new User("username" + i, "password" + i, "firstName" + i, "lastName" + i,
					"address" + i);
			userDao.create(user);

			Random random = new Random();
			Product product = new Product("product" + i, "description" + i,
					random.nextDouble() * 100);
			productDAO.create(product);
		}

		User user = userDao.get(15);
		Product product = productDAO.get(16);
		Purchase purchase = new Purchase(user, product, new Date());

		purchaseDAO.create(purchase);
	}

	@Test
	public void getUser() {
		User user = DAOFactory.get().getUserDAO().get(3);
		System.out.println(user);
	}

	@Test
	public void getProduct() {
		Product product = DAOFactory.get().getProductDAO().get(24);
		System.out.println(product);
	}

	@Test
	public void getPurchases() {
		List<Purchase> purchases = DAOFactory.get().getPurchaseDAO().getPurchases();
		for (Purchase purchase : purchases) {
			System.out.println(purchase);
		}
	}

}
