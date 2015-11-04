package aspects;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext ap = new ClassPathXmlApplicationContext("aspects/spring-context.xml");
				
		CPU c = ap.getBean("Nvidia", CPU.class);
		c.getName();
		c.print();
		CPU i = ap.getBean("Intel", CPU.class);
		i.getName();
		try {
			c.error();
		} catch (Exception e) {
			System.err.println("THROW EXCEPTION");
		}
		
		
		
		ap.close();
	}		
}
