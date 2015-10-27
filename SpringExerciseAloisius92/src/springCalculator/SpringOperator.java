package springCalculator;

public class SpringOperator {
	public static final String UNKNOW = "Unknow";
	public static final String ADD = "+";
	public static final String SUBTRACT = "-";
	public static final String MULTIPLY = "*";
	public static final String DIVIDE = "/";
	
	private String operator = UNKNOW;
	
	public SpringOperator() {
	}

	public SpringOperator(String operator) {
		this.setOperator(operator);
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void printOperator(){
		System.out.println("Operator: " + getOperator());	
	}
}
