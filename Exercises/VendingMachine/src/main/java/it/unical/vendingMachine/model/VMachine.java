package it.unical.vendingMachine.model;

import java.util.ArrayList;

public class VMachine {
	
	private ArrayList<Double> purchase;
	private double money;
	
	
	public ArrayList<Double> getPurchase() {
		return purchase;
	}
	
	public void setPurchase(ArrayList<Double> purchase) {
		this.purchase = purchase;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
}
