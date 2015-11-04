package aspects;

public class Logging {

	public static void beforeOperation() {
		System.out.println("Print before operation");
	}
	
	public static void afterOperation() {
		System.out.println("Print after operation");
	}
	
}
