package simple;

public class Computer {
	private CPU cpu;

	public Computer() {		
	}
	
	public Computer(CPU c) {
		cpu = c;
	}
	
	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	
	public void print() {
		System.out.print("Computer CPU: ");
		cpu.print();
	}
}
