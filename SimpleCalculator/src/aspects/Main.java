package aspects;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aspects/spring-context.xml");
		
		Calculator calculator = context.getBean("calculator", Calculator.class);
		Calculator.doSum(1, 1);
		
		
		context.close();
	}

}
