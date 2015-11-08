package calculator;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	
	public static void main(String[] args) {
		Main m = new Main();
		m.Spring();
		
	}

	private void Spring() {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext ap = 
				new ClassPathXmlApplicationContext("calculator/spring-context.xml");
	
		
		Operation sum=ap.getBean("Sum", Operation.class);
		Operation subtraction=ap.getBean("Subtraction", Operation.class);
		Operation multiplication=ap.getBean("Multiplication", Operation.class);
		Operation division=ap.getBean("Division", Operation.class);
		
		Calculator calc = ap.getBean("Calculator", Calculator.class);
		
		calc.getParameter();
		ap.close();
	}	
	
	
}
