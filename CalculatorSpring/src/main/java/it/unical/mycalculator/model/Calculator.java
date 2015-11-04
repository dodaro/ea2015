package it.unical.mycalculator.model;

public class Calculator {
	private double number1;
	private double number2;

	public Calculator() {
	}

	public double getNumber1() {
		return number1;
	}

	public void setNumber1(double number1) {
		this.number1 = number1;
	}

	public double getNumber2() {
		return number2;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}

	public Double execute(char operation) {
		switch (operation) {
		case '+':
			return number1 + number2;
		case '-':
			return number1 - number2;
		case '/':
			if (number2 == 0)
				return null;
			return number1 / number2;
		case '*':
			return number1 * number2;
		default:
			return 0.0;
		}
	}
}