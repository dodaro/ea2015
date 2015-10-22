package simple;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.useSpring();
	}	
	
	void useSpring() {
		ConfigurableApplicationContext ap = 
				new ClassPathXmlApplicationContext("simple/spring-context.xml");

		CPU intel = ap.getBean("Intel", CPU.class);
		intel.print();

		CPU nvidia = ap.getBean("Nvidia", CPU.class);		
		nvidia.print();

		CPU mediatek = ap.getBean("Mediatek", CPU.class);
		mediatek.print();

		Computer comp = ap.getBean("Computer1", Computer.class);
		comp.print();

		Computer comp2 = ap.getBean("Computer2", Computer.class);
		comp2.print();

		Computer comp3 = ap.getBean("Computer3", Computer.class);
		comp3.print();

//		Computer comp4 = ap.getBean("ComputerAnnotation", Computer.class);
//		comp4.print();
		ap.close();
	}
}
