package annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfigurator {
	
	@Bean
	public CPU cpu1()
	{
		return new CPU("Nvidia");
	}

	@Bean
	public CPU cpu2()
	{
		CPU c = new CPU();
		c.setName("Intel");		
		return c;
	}
	
	@Bean
	public Computer computer1()
	{
		Computer c = new Computer(cpu2());
		return c;
	}
}
