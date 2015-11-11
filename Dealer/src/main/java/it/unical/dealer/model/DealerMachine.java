package it.unical.dealer.model;

public class DealerMachine {

	private String[] productsChoosen;

	private int[] choosenProd;
	private int money;
	private String message;
	
	public DealerMachine() {
		
	}
	
	public int[] getChoosenProd() {
		return choosenProd;
	}

	public void setChoosenProd(int[] choosenProd) {
		this.choosenProd = choosenProd;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String purchase() {
		message = "";
		int val = 0;
		for (int i = 0; i < choosenProd.length; i++) {
			val += choosenProd[i];
		}
		if (money < val)
			message = message.concat("You need to add " + String.valueOf(val - money) + " euro to purchase");
		else {
			message = message.concat("Thanks for purchase. \n Here your rest :" + String.valueOf(money - val));
		}
		return message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String purchaseProd() {
		message = "";
		int val = 0;
		for (String p : productsChoosen) {
			val += Integer.valueOf(p.charAt(p.length()-1));
		}
		if (money < val)
			message = message.concat("You need to add " + String.valueOf(val - money) + " euro to purchase");
		else {
			message = message.concat("Thanks for purchase. \n Here your rest :" + String.valueOf(money - val));
		}
		return message;
	}



	public String[] getProductsChoosen() {
		return productsChoosen;
	}



	public void setProductsChoosen(String[] productsChoosen) {
		this.productsChoosen = productsChoosen;
	}
}
