package aspects;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextProvider implements ApplicationContextAware{

	private static ApplicationContextProvider instance = null;
	private ConfigurableApplicationContext ctx;
	
	private ApplicationContextProvider() {
		setApplicationContext(new ClassPathXmlApplicationContext("aspects/spring-context.xml"));
	}

	
	public static ApplicationContextProvider getInstance() {
			
		if(instance == null){
			instance = new ApplicationContextProvider();
		}
		
		return  instance;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {

		ctx = (ConfigurableApplicationContext) arg0;
	}


	public ConfigurableApplicationContext getCtx() {
		return ctx;
	}


}
