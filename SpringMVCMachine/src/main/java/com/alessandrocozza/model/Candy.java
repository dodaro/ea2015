package com.alessandrocozza.model;

public class Candy 
{
	private String name;
	private float value;

	public Candy(String name, float value) 
	{
		this.name = name;
		this.value = value;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public float getValue() 
	{
		return value;
	}
	
	public void setValue(float value) 
	{
		this.value = value;
	}	
}