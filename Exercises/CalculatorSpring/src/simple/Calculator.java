package simple;


public class Calculator {

	private String brand;
	
	public Calculator(String brand) {
		
		setBrand(brand);
	}

	public String getBrand() {
		return brand;
	}

	private void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public int subtraction(int a, int b) {
		return a-b;
	}
	
	public int multiplication(int a, int b) {
		return a*b;
	}
	
	public double division(double a, double b) {
		return a/(b == 0 ? 1 : b);
	}

	
	@Override
	public String toString() {
		return "Calculator [brand=" + brand + "]";
	}

	
}
