package com.alessandrocozza.model;

import java.util.Set;

public class User 
{
	private float money;
	private Set<Candy> selectedCandies;

	public User()
	{
		money = 0;
		selectedCandies = null;
	}	

	public Set<Candy> getSelectedCandies() 
	{
		return selectedCandies;
	}

	public void setSelectedCandies(Set<Candy> selectedCandies) 
	{
		this.selectedCandies = selectedCandies;
	}

	public float getMoney() 
	{
		return money;
	}

	public void setMoney(float money) 
	{
		this.money = money;
	}
}
