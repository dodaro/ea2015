package xmlcalc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext ap = new ClassPathXmlApplicationContext("xmlcalc/spring-context.xml");
		Calculator c=ap.getBean("Calc1",Calculator.class);
		c.performCalculation();
		c.print();
		
		Calculator c2=ap.getBean("Calc2",Calculator.class);
		c2.performCalculation();
		c2.print();
		
		Calculator c3=ap.getBean("Calc3",Calculator.class);
		c3.performCalculation();
		c3.print();
		
		Calculator c4=ap.getBean("Calc4",Calculator.class);
		c4.performCalculation();
		c4.print();
		
		Calculator c5=ap.getBean("Calc5",Calculator.class);
		c5.performCalculation();
		c5.print();
		
		Calculator c6=ap.getBean("Calc6",Calculator.class);
		c6.performCalculation();
		c6.print();
		
		ap.close();
	}

}
