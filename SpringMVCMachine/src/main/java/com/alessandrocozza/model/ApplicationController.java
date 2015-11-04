package com.alessandrocozza.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ApplicationController 
{
	private static ApplicationController _instance = null;
	
	public static ApplicationController getInstance()
	{
		if (_instance == null)
			_instance = new ApplicationController();
		return _instance;
	}
	
	private HashSet<Candy> candies;
	
	private ApplicationController()
	{
		setCandies(new HashSet<Candy>());
	}

	public HashSet<Candy> getCandies() 
	{
		return candies;
	}

	public void setCandies(HashSet<Candy> candies) 
	{
		this.candies = candies;
	}
	
	public void getHashMap()
	{
		
	}
}
