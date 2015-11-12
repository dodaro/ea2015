package com.alessandrocozza.model;

public class Car
{
	private String brand;
	private String model;
	private float value;
	private String info1;
	private String info2;
	private String info3;
	
	public Car(String brand, String model, float value, String info1, String info2, String info3)
	{
		this.brand = brand;
		this.model = model;
		this.value = value;
		this.info1 = info1;
		this.info2 = info2;
		this.info3 = info3;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public float getValue()
	{
		return value;
	}

	public void setValue(float value)
	{
		this.value = value;
	}

	public String getInfo1()
	{
		return info1;
	}

	public void setInfo1(String info1)
	{
		this.info1 = info1;
	}

	public String getInfo2()
	{
		return info2;
	}

	public void setInfo2(String info2)
	{
		this.info2 = info2;
	}

	public String getInfo3()
	{
		return info3;
	}

	public void setInfo3(String info3)
	{
		this.info3 = info3;
	}
}