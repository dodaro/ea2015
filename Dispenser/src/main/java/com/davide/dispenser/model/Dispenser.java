package com.davide.dispenser.model;


public class Dispenser {
	
	private Products p1;
	private Products p2;
	private Products p3;
		   /*
		 	* 
		 	* 
	private Products n;
		 	*/
	
	/* AVREI potuto creare una lista di prodotti, ma poichè a lezione non è stato ancora spiegato il meccanismo del binding ho preferito 
	 * mantenermi su un esempio semplice senza liste, in quanto ho dovuto fare una "sporca magia" per poter utilizzare un oggetto 
	 * attraverso il modelAttribute e per poter "memorizzare" un dato senza database*/
	
	private boolean stateSelection;
	
	private int idSelect;
	
	private double moneyOnMachine;
	private double remainder;
	private double missing;
	
	public Dispenser() {
		// TODO Auto-generated constructor stub
	}

	public Products getP1() {
		return p1;
	}

	public void setP1(Products p1) {
		this.p1 = p1;
	}

	public Products getP2() {
		return p2;
	}

	public void setP2(Products p2) {
		this.p2 = p2;
	}

	public Products getP3() {
		return p3;
	}

	public void setP3(Products p3) {
		this.p3 = p3;
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
		
		switch (this.idSelect) {
		case 1:
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
				
			break;
		case 2:
			if(p2.getPrice()==this.moneyOnMachine){
				this.stateSelection=true;
				this.remainder=0.0;
				this.missing=0.0;
			}
			else if(p2.getPrice()<this.moneyOnMachine){
				this.stateSelection=true;
				this.remainder=this.moneyOnMachine-p2.getPrice();
				this.moneyOnMachine=this.moneyOnMachine-this.remainder;
				this.missing=0.0;
			}
			else{
				this.missing=p2.getPrice()-this.moneyOnMachine;
			}
			
			break;
		case 3:	
			
			if(this.getP3().getPrice()==this.moneyOnMachine){
				this.stateSelection=true;
				this.remainder=0.0;
				this.missing=0.0;
			}
			else if(this.getP3().getPrice()<this.moneyOnMachine){
				this.stateSelection=true;
				this.remainder=this.moneyOnMachine-p3.getPrice();
				this.moneyOnMachine=this.moneyOnMachine-this.remainder;
				this.missing=0.0;
			}
			else{
				this.missing=p3.getPrice()-this.moneyOnMachine;
			}

			break;
			
		default:
			break;
		}	
	}
	
}
