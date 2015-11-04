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
		ConfigurableApplicationContext ap = new AnnotationConfigApplicationContext(ComputerConfigurator.class);
		CPU cpu1Main = ap.getBean("cpu1", CPU.class);
		cpu1Main.print();

		Computer computer1Main = ap.getBean("computer1", Computer.class);
		computer1Main.print();
		ap.close();
	}
}
