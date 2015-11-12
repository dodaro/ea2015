package com.alessandrocozza.model;

public class Color
{
	private String name;
	private float value;
	
	public Color(String name, float value)
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
