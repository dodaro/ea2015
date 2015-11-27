package persistence;

import java.util.List;

public interface BookingDAO {
	public void delete(Booking booking);

	public List<Booking> getAllBookings();

	public List<Booking> getByPriceGreaterThan(Double price);

	public List<Booking> getByPriceLessThan(Double price);

	public Booking getBooking(Integer i);

	public void create(Booking booking);

	public Long numberOfBookings();

	public void update(Booking booking);
}
