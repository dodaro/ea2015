package aspects;

import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;

public class Calculator{

	private Command command;
	
	public Calculator() {
	}
	
	
	public int getOperation(String op, int v1, int v2){
		
		try {
			
			ConfigurableApplicationContext ctx = ApplicationContextProvider.getInstance().getCtx();
			command = (Command) ctx.getBean(op, Class.forName("aspects." + op));
			command.init(v1, v2);
			return command.execute();
			
		} catch (BeansException | ClassNotFoundException e) {
			e.getMessage();
			return (int) Double.NaN;
		}

	}

}
