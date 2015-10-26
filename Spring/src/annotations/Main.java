package annotations;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotations.CPU;
import annotations.Computer;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		m.useSpringAnnotations();
	}
		
	void useSpringAnnotations() {		
		ConfigurableApplicationContext ap = 
				new AnnotationConfigApplicationContext(ComputerConfigurator.class);
		CPU cpu1 = ap.getBean("cpu1",CPU.class);
		cpu1.print();
		
		Computer computer1 = ap.getBean("computer1", Computer.class);
		computer1.print();
		ap.close();
	}
}
