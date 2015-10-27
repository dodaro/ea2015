package simple;

public class Checker {

	
	public void check(double a, double b) {
		
		if(checkZeroPresence(a, b)) {

			System.out.println("WARNING: one of the two parameter is equal to 0");
		}
		else {
			
			System.out.println("No zero founds in parameters");
		}
	}
	
	
	private boolean checkZeroPresence(double a, double b) {
		return a*b == 0;
	}
	
}
