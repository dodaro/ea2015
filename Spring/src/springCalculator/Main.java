package springCalculator;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		m.useSpring();
	}	
	
	void useSpring() {
		ConfigurableApplicationContext ap = 
				new ClassPathXmlApplicationContext("springCalculator/spring-context.xml");

		SpringOperator sumOperator = ap.getBean("Sum", SpringOperator.class);
		sumOperator.printOperator();

		SpringOperator subtractOperator = ap.getBean("Subtract", SpringOperator.class);
		subtractOperator.printOperator();

		SpringOperator multiplyOperator = ap.getBean("Multiply", SpringOperator.class);
		multiplyOperator.printOperator();

		SpringOperator divideOperator = ap.getBean("Divide", SpringOperator.class);
		divideOperator.printOperator();
		
		SpringCalculator calculator1 = ap.getBean("Calculator1", SpringCalculator.class);
		calculator1.print();

		SpringCalculator calculator2 = ap.getBean("Calculator2", SpringCalculator.class);
		calculator2.print();
		
		SpringCalculator calculator3 = ap.getBean("Calculator3", SpringCalculator.class);
		calculator3.print();
		ap.close();
	}
}
