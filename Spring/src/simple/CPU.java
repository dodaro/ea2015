package simple;

public class CPU {
	private String name = "empty";	
	
	public CPU() {
	}
	
	public CPU(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void print(){
		System.out.println("Name is " + name);	
	}
	
	public void init() {
		System.out.println("Init " + name);
	}
	
	public void destroy() {
		System.out.println("Destroy " + name);
	}
}
