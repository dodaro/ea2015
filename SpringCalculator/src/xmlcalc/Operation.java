package xmlcalc;

public class Operation {
	
	private double n1;
	private double n2;
	private Operator o;
	
	public Operation() {
		
	}
	public Operation(double a,double b,Operator op){
		this.n1=a;
		this.n2=b;
		this.o=op;
	}
	public double execute() {
		double result=0;
		switch (o) {
		case SUM:
			result= n1 + n2;
			break;
		case SUBTRACTION:
			result= n1 - n2;
			break;
		case DIVISION:
			if (n2 != 0)
				result= n1 / n2;
			break;
		case MULTIPLICATION:
			result= n1 * n2;
			break;
		}
		return result;
	}

	public Operator getO() {
		return o;
	}

	public void setO(Operator o) {
		this.o = o;
	}

	public double getN2() {
		return n2;
	}

	public void setN2(double n2) {
		this.n2 = n2;
	}

	public double getN1() {
		return n1;
	}

	public void setN1(double n1) {
		this.n1 = n1;
	}

}
