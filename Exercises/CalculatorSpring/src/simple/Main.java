package simple;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext ac = 
				new ClassPathXmlApplicationContext("simple/spring-context.xml");
		
		
		Calculator c = ac.getBean("Calc", Calculator.class);
		System.out.println(c);
		System.out.println(c.division(10, 3));
		System.out.println("--------------------------------");
		
		
		ScientificCalculator sc = ac.getBean("SciCalc", ScientificCalculator.class);
		System.out.println(sc);
		System.out.println(sc.division(10.0f, 0.0f));
		System.out.println(sc.squareRoot(16));
		
		
		
		ac.close();
	}
	
	
}
