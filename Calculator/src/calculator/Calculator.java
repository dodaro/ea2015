package calculator;

public class Calculator {

	public Calculator() {
	}

	public double performCalculation(double a, double b, Operator op) {
		switch (op) {
		case SUM:
			return a + b;
		case SUBTRACTION:
			return a - b;
		case DIVISION:
			return a / b;
		case MULTIPLICATION:
			return a * b;
		}
		return 0;
	}

	public double square(double value) {
		return value * value;
	}

}
