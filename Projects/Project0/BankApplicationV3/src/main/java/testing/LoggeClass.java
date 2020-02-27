package testing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
public class LoggeClass {
	  static final Logger logger = (Logger) LogManager.getLogger(Logger.class.getName());
	  public void doIt() {
	    
	    logger.trace("Did it again!");
	    
	}
}

