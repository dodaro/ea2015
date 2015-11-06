package aspects;


public class Main {
	public static void main(String[] args) {
		
		Calculator c = ApplicationContextProvider.getInstance().getCtx().getBean("Calculator",Calculator.class);
		
		int resSum = c.getOperation("Sum", 2, 1);
		
		int resDiv = c.getOperation("Divide", 1, 1);
		
		
		System.out.println("Sum = " + resSum + ", Div = " + resDiv );
		ApplicationContextProvider.getInstance().getCtx().close();
		
	}		
}
