package persistence;

public interface ClassDAO {

	public void create(Object obj);

	public Object getById(Integer id);

	public Object getByUsername(String username);

	public void update(Object obj);

	public void delete(Object obj);

	public int numberOfTuple();

}
