package springCalculator;

public class SpringCalculator {
	private SpringOperator operator;

	public SpringCalculator() {		
	}

	public SpringCalculator(SpringOperator operator) {
		this.setOperator(operator);
	}


	public SpringOperator getOperator() {
		return operator;
	}

	public void setOperator(SpringOperator operator) {
		this.operator = operator;
	}

	public double executeOperations(double a, double b) throws Exception {
		switch (operator.getOperator()) {
		case SpringOperator.ADD:
			return a + b;
		case SpringOperator.SUBTRACT:
			return a - b;
		case SpringOperator.MULTIPLY:
			return a / b;
		case SpringOperator.DIVIDE:
			return a * b;
		default: 
			throw new Exception("Unknow operation");
		}
	}	

	public void print() {
		System.out.print("Calculator - ");
		operator.printOperator();	
	}
}
