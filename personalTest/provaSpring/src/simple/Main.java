package simple;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext ac = 
				new ClassPathXmlApplicationContext("simple/spring-context.xml");
		
		
		Calculator c = ac.getBean("Calc", Calculator.class);
		c.print();
		
		
		
		ac.close();
	}
	
	
}
