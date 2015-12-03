package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class BookingDAOImpl implements BookingDAO {	

	@Override
	public void create(Booking booking) {
		DBHandler.create(booking);
	}

	@Override
	public void update(Booking booking) {
		DBHandler.update(booking);
	}

	@Override
	public void delete(Booking booking) {
		DBHandler.delete(booking);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getAllBookings() {
		Session session = DBHandler.getSession();
		List<Booking> bookings = (List<Booking>) session.createQuery("from Booking").list();
		session.close();
		return bookings;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getByPriceGreaterThan(Double price) {
		Session session = DBHandler.getSession();
		List<Booking> bookings = (List<Booking>) session.createQuery("from Booking b where b.price > " + price).list();
		session.close();
		return bookings;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getByPriceLessThan(Double price) {
		Session session = DBHandler.getSession();
		List<Booking> bookings = (List<Booking>) session.createQuery("from Booking b where b.price < " + price).list();
		session.close();
		return bookings;
	}

	@Override
	public Booking getBooking(Integer id) {
		Session session = DBHandler.getSession();
		String queryString = "from Booking b where b.id = :id_booking";
		Query query = session.createQuery(queryString);
		query.setParameter("id_booking", id);
		Booking b = (Booking) query.uniqueResult();
		session.close();
		return b;
	}
	
	@Override
	public Long numberOfBookings() {
		Session session = DBHandler.getSession();
		Long size = (Long) session.createQuery("select count(*) from Booking").uniqueResult();
		session.close();
		return size;
	}
}
