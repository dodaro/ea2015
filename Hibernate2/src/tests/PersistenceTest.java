package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.Booking;
import persistence.BookingDAO;
import persistence.BookingDAOImpl;
import persistence.User;
import persistence.UserDAO;
import persistence.UserDAOImpl;

public class PersistenceTest {

	static UserDAO userDao;
	static List<User> users;
	static BookingDAO bookingDao;
	static List<Booking> bookings;

	@BeforeClass
	static public void init() {
		userDao = new UserDAOImpl();
		users = new ArrayList<User>();
		bookingDao = new BookingDAOImpl();
		bookings = new ArrayList<Booking>();
		initDB();
	}

	static public void initDB() {
		for (int i = 0; i < 100; i++) {
			User u = new User(i, "username" + i, "password" + i);
			users.add(u);
			userDao.create(u);
		}

		for (int i = 0; i < 10; i++) {
			Booking b = new Booking(i, 10.0 * i, users.get(i % 2));
			bookings.add(b);
			bookingDao.create(b);
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
	public void testTotalPriceForUser0() {
		assertEquals(new Double(200.0), userDao.getTotalPrice(users.get(0)));
	}

	@Test
	public void testNumberOfBookingsForUser0() {
		assertEquals(new Integer(5), new Integer(userDao.get("username0").getBookings().size()));
	}

	@Test
	public void testNumberOfBookings() {
		assertEquals(new Long(10), bookingDao.numberOfBookings());
	}

	@Test
	public void testGreaterThanPrice() {
		assertEquals(9, bookingDao.getByPriceGreaterThan(0.0).size());
	}

	@Test
	public void testLessThanPrice() {
		assertEquals(1, bookingDao.getByPriceLessThan(10.0).size());
	}

	@Test
	public void testBookingsFromUser0() {
		assertEquals(5, userDao.getBookings(users.get(0)).size());
	}

	@Test
	public void getBookingById() {
		assertEquals(new Integer(1), bookingDao.getBooking(1).getId());
	}

	@Test
	public void testNumberOfUsersAfterDeletion() {
		userDao.delete(users.get(1));
		assertEquals(99, userDao.numberOfUsers());
		assertEquals(new Long(5), bookingDao.numberOfBookings());
	}

	// @Test
	// public void deleteBooking()
	// {
	// bookingDao.delete(bookings.get(0));
	// assertEquals(new Long(9), bookingDao.numberOfBookings());
	// assertEquals(4, userDao.getBookings(users.get(0)).size());
	// }
}
