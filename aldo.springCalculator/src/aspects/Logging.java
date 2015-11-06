package aspects;

public class Logging {
	
	public void beforeGet()
	{
		System.out.println("I am invoking a method get");
	}
	
	public void beforeSet()
	{
		System.out.println("I am invoking a method set");
	}
	
	public void beforePrint()
	{
		System.out.println("I am printing");		
	}
	
	public void afterError()
	{
		System.out.println("Error");
	}
	
	public void afterGet()
	{
		System.out.println("I invoked a method get");
	}
	
	public void afterSet()
	{
		System.out.println("I invoked a method set");
	}
}
