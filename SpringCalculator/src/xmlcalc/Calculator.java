package xmlcalc;

public class Calculator {

	private Operation op;
	private double result;

	public Calculator() {

	}

	public Calculator(Operation o) {
		this.op = o;

	}

	public void performCalculation() {
		result = op.execute();

	}


	public void print() {
		String out = "";
		boolean error = false;
		out = out.concat(String.valueOf(op.getN1()) + " ");
		switch (op.getO()) {
		case SUM:
			out = out.concat("+ ");
			break;
		case SUBTRACTION:
			out = out.concat("- ");
			break;
		case DIVISION:
			out = out.concat(": ");
			if (op.getN2() == 0)
				error = true;
			break;
		case MULTIPLICATION:
			out = out.concat("* ");
			break;
		}
		out = out.concat(String.valueOf(op.getN2()) + " ");
		out = out.concat("= " + result);
		if (!error)
			System.out.println(out);
		else {
			System.out.println("Impossible to perform division by 0.");
		}

	}
	public void beforeCalc(){
		System.out.println("Init calculation");
	}
	
	public void afterCalc(){
		System.out.println("Calculation completed");
	}
	public void beforePrint(){
		System.out.println("Init printing result");
	}
	public void afterPrint(){
		System.out.println("Result printed\n");
	}
	
	
	public double getResult() {
		return result;
	}
	
	public void setResult(double result) {
		this.result = result;
	}

	public Operation getOp() {
		return op;
	}

	public void setOp(Operation op) {
		this.op = op;
	}
	
	
}
