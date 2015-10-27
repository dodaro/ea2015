package simple;

public class ScientificCalculator extends Calculator{

	
	public ScientificCalculator(String brand) {
		super(brand);
	}


	public double squareRoot(double num) {
		return Math.sqrt(num);
	}

	
	@Override
	public String toString() {
		return "ScientificCalculator [ " + super.toString() + " ]";
	}
	
	
	
}
