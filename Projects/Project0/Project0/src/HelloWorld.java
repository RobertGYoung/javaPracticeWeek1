


import org.apache.logging.log4j.*;


public class HelloWorld {
 private static final Logger log = LogManager.getLogger();

 public static void main(String args[]) {
  log.info("Starting application");
  System.out.println("Hello World");
  log.info("Execution completed");
 }
}


