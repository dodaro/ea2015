package simple;

public class Calculator {

	private String name;
	
	public Calculator() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Calculator [name=" + name + "]";
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	
}
