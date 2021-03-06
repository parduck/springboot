package com.sec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class LoggingRunner implements ApplicationRunner {

	private Logger logger = LoggerFactory.getLogger(LoggingRunner.class);
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.trace("Trace log message..");
		logger.debug("Debug log message..");
		logger.info("Info log message..");
		logger.warn("Warn log message..");
		logger.error("Error log message..");

	}

}
