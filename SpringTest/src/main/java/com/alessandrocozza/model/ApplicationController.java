package com.alessandrocozza.model;

import java.util.List;

public class ApplicationController
{
	private List<Car> cars;
	private List<Color> colors;

	public ApplicationController()
	{}
	
	public ApplicationController(List<Car> cars, List<Color> colors)
	{
		this.cars = cars;
		this.setColors(colors);
	}

	public List<Car> getCars()
	{
		return cars;
	}

	public void setCars(List<Car> cars)
	{
		this.cars = cars;
	}

	public List<Color> getColors()
	{
		return colors;
	}

	public void setColors(List<Color> colors)
	{
		this.colors = colors;
	}
}