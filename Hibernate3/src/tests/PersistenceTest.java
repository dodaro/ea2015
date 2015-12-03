package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.Promotion;
import persistence.PromotionDAO;
import persistence.PromotionDAOImpl;
import persistence.User;
import persistence.UserDAO;
import persistence.UserDAOImpl;

public class PersistenceTest {

	static UserDAO userDao;
	static PromotionDAO promotionDao;
	static List<User> users;
	static List<Promotion> promotions;

	@BeforeClass
	static public void init() {
		userDao = new UserDAOImpl();
		promotionDao = new PromotionDAOImpl();
		users = new ArrayList<User>();
		promotions = new ArrayList<Promotion>();
		initDB();
	}

	static public void initDB() {
		for (int i = 0; i < 100; i++) {
			User u = new User(i, "username" + i, "password" + i);
			users.add(u);
			userDao.create(u);
		}

		for (int i = 0; i < 10; i++) {
			Calendar c = new GregorianCalendar();
			c.set(Calendar.YEAR, 2015);
			c.set(Calendar.MONTH, Calendar.DECEMBER);
			c.set(Calendar.DAY_OF_MONTH, 25);
			Date d = c.getTime();
			Promotion p = new Promotion(i, d, d, 30);
			p.addUser(users.get(0));
			p.addUser(users.get(1));
			promotions.add(p);
			promotionDao.create(p);
		}
	}

	@Test
	public void testGetUserByUsername() {
		assertEquals(new Integer(11), userDao.get("username10").getId());
	}

	@Test
	public void testGetUserByUnusedUsername() {
		assertNull(userDao.get("username101"));
	}

	@Test
	public void testGetUserById() {
		assertEquals("username9", userDao.get(10).getUsername());
	}

	@Test
	public void testNumberOfUsers() {
		assertEquals(100, userDao.numberOfUsers());
	}

	@Test
	public void testNumberOfPromotionsUser1() {
		assertEquals(10, userDao.get(1).getPromotions().size());
	}

	@Test
	public void testDatePromotion() {
		Calendar c = new GregorianCalendar(2015, GregorianCalendar.DECEMBER, 25);
		assertEquals(c.getTime(), promotionDao.get(2).getBeginDate());
	}

	@Test
	public void deletePromotion1() {
		assertEquals(new Long(10), promotionDao.numberOfPromotions());
		assertEquals(2, promotionDao.get(1).getUsers().size());
		promotionDao.delete(promotions.get(0));
		promotions.remove(promotions.get(0));
		assertEquals(new Long(9), promotionDao.numberOfPromotions());
		assertEquals(9, userDao.get(1).getPromotions().size());
		assertEquals(100, userDao.numberOfUsers());
	}

	@Test
	public void deleteUser1() {
		userDao.delete(users.get(1));
		users.remove(users.get(1));
		assertEquals(1, promotionDao.get(1).getUsers().size());
	}
}
