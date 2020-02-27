package com.revature.day04.loggingEx;
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.core.Logger;
	public class Bar {
		  static final Logger logger = (Logger) LogManager.getLogger(Bar.class.getName());
		  public void doIt() {
		    
		    logger.trace("Did it again!");
		    
		}
	}
