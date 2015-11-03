package it.unical.distributore.model;


public class Purchase {

	boolean cheked = false;
	private int coins = 0;
	private int[] selected;
	
	public Purchase() {
		setSelected(new int[10]);
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int[] getSelected() {
		return selected;
	}

	public void setSelected(int[] selected) {
		this.selected = selected;
	}
	
}
