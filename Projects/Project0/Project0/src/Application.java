import org.apache.log4j.*;

public class Application {
	public static void main(String[] args) {
		
	
	Logger logger = Logger.getLogger(MyClass.class);
	BasicConfigurator.configure();
	logger.info("This is my first log4j's statement");
	}
}
