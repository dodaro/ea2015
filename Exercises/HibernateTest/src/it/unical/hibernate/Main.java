package it.unical.hibernate;

import java.util.ArrayList;
import java.util.List;

import it.unical.hibernate.dao.concrete.UserDAO;
import it.unical.hibernate.data.User;

public class Main {

	
	static UserDAO userDao;
	static List<User> users;

	public static void init() {
		
		userDao = new UserDAO();
		users = new ArrayList<User>();
		initDB();
	}

	public static void initDB() {
		
		for (int i = 0; i < 100; i++) {
			User u = new User(i, "username" + i, "password" + i);
			users.add(u);
			userDao.create(u);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		init();
		
		System.out.println("-----------START TEST-------------------");
		System.out.println(userDao.get("username10").getID());
		System.out.println(userDao.get(11));
		System.out.println(userDao.getUsersWithAge(0));

		
	}
	
}
