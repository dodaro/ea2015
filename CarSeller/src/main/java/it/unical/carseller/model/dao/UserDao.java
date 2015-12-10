package it.unical.carseller.model.dao;

import it.unical.carseller.model.User;

public interface UserDao {
	void create(User u);
	User retrieve(String username);
	boolean exists(String username);
	Long numberOfUsers();
	void update(User u);
	void delete(User u);	
}
