package com.alessandrocozza.model;

public class User 
{
	private float money;
	private float[] selectedCandies;

	public User()
	{
		money = 0;
		selectedCandies = null;
	}	

	public float[] getSelectedCandies() 
	{
		return selectedCandies;
	}

	public void setSelectedCandies(float[] selectedCandies) 
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
