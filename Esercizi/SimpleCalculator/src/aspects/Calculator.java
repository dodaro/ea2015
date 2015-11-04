package aspects;

public class Calculator {

		public static int doSum(int a, int b ) {
			return a + b;
		}
		
		public static int doSub(int a, int b ) {
			return a - b;
		}
		
		public static int doMultiply(int a, int b) {
			return a * b;
		}
	
		public static double doDivide(int a,int b) throws Exception {
			if ( b != 0  ) {
				return a/b;
			} else {
				throw new IllegalArgumentException("Division by zero!");
			}
		}
}
