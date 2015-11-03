package it.unical.vendingMachine.model;

import java.util.ArrayList;

public class VMachine {
	
	private ArrayList<String> goodies;
	private double money;
	

	public ArrayList<String> getGoodies() {
		return goodies;
	}

	public void setGoodies(ArrayList<String> goodies) {
		this.goodies = goodies;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
}
