package spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	public static void main(String[] args)
	{
		Main m = new Main();
		m.useSpring();
	}

	void useSpring()
	{
		ConfigurableApplicationContext ap = new ClassPathXmlApplicationContext("spring/spring-context.xml");

		Calculator calc1 = ap.getBean("Calc1", Calculator.class);
		System.out.println("Calc1: " + calc1.performCalculation());
		Calculator calc2 = ap.getBean("Calc2", Calculator.class);
		System.out.println("Calc2: " + calc2.performCalculation());
		Calculator calc3 = ap.getBean("Calc3", Calculator.class);
		System.out.println("Calc3: " + calc3.performCalculation());
		Calculator calc4 = ap.getBean("Calc4", Calculator.class);
		System.out.println("Calc4: " + calc4.performCalculation());
		
		ap.close();
	}
}
