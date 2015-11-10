package com.davide.dispenser.model;

import java.util.ArrayList;

public class Dispenser {
	
	private ArrayList<Products> list;
	private boolean stateSelection;
	
	private int idSelect;
	
	private double moneyOnMachine;
	private double remainder;
	private double missing;
	
	public Dispenser() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Products> getList() {
		return list;
	}
	
	public void setList(ArrayList<Products> list) {
		this.list = list;
	}

	public double getMoneyOnMachine() {
		return moneyOnMachine;
	}


	public void setMoneyOnMachine(double moneyOnMachine) {
		this.moneyOnMachine = moneyOnMachine;
	}
	
	
	
	public boolean isStateSelection() {
		return stateSelection;
	}

	public  void setStateSelection(boolean stateSelection) {
		this.stateSelection = stateSelection;
	}

	public int getIdSelect() {
		return idSelect;
	}

	public void setIdSelect(int idSelect) {
		this.idSelect = idSelect;
	}

	
	public double getRemainder() {
		return remainder;
	}

	public void setRemainder(double remainder) {
		this.remainder = remainder;
	}
	
	public double getMissing() {
		return missing;
	}

	public void setMissing(double missing) {
		this.missing = missing;
	}

	public void insert(double money){
		
		this.moneyOnMachine=this.moneyOnMachine+money;
	}

	public void supplies(){
		
		Products p1=list.get(idSelect-1);
		if(p1.getPrice()==this.moneyOnMachine){
			this.stateSelection=true;
			this.remainder=0.0;
			this.missing=0.0;
		}
		else if(p1.getPrice()<this.moneyOnMachine){
			this.stateSelection=true;
			this.remainder=this.moneyOnMachine-p1.getPrice();
			this.moneyOnMachine=this.moneyOnMachine-this.remainder;
			this.missing=0.0;
		}
		else{
			this.missing=p1.getPrice()-this.moneyOnMachine;
		}
	}
	
}
