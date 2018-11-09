package com.ktds.common;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class KafkaLogger {
	
	private Logger logger = LoggerFactory.getLogger("qos");
	
	public void info(String message) {
		
		String time = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
		String fullFormatMessage = time + message;
		KafkaSender.send(fullFormatMessage);
		logger.info(message);
	}

}
