package it.unical.vendingEa2015.model;

import java.util.List;

public class Vmachine2 {
	private List<Good> goodies = null;
	private double money;
	private double purchased;
	
	public Vmachine2() {
		System.out.println("Creo Vmachine");
	}

	public List<Good> getGoodies() {
		return goodies;
	}

	public void setGoodies(List<Good> goodies) {
		this.goodies = goodies;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getPurchased() {
		return purchased;
	}

	public void setPurchased(double purchased) {
		this.purchased = purchased;
	}

	@Override
	public String toString() {
		return "Money inserted: " + money + ", Purchased: " + purchased;
	}

}
