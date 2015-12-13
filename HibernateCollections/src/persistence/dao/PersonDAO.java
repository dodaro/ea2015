package persistence.dao;

import persistence.Person;

public interface PersonDAO {
	public void create(Person p);
	public Person get(Integer id);	
	public void update(Person p);
	public void delete(Person p);
	public Integer numberOfMobileNumbers(Integer id);
	public Integer numberOfAddresses(Integer id);
}
