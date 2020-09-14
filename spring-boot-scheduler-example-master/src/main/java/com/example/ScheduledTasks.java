package com.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

//import ch.qos.logback.classic.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

//	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Autowired
	private SendMail sendMail;

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

//	@Scheduled(fixedRate = 2000)
//	public void scheduleTaskWithFixedRate() {
//		logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
//	}
//
//	@Scheduled(fixedDelay = 2000)
//	public void scheduleTaskWithFixedDelay() {
//		logger.info("Fixed Delay Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException ex) {
//			logger.error("Ran into an error {}", ex);
//			throw new IllegalStateException(ex);
//		}
//	}
//
//	@Scheduled(fixedRate = 2000, initialDelay = 5000)
//	public void scheduleTaskWithInitialDelay() {
//		logger.info("Fixed Rate Task with Initial Delay :: Execution Time - {}",
//				dateTimeFormatter.format(LocalDateTime.now()));
//	}

	@Scheduled(cron = "${cron.expression}")
	public void scheduleTaskWithCronExpression() {
//		logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		sendMail.sendEmail();
		System.out.println("Cron Task :: Execution Time - {}" + dateTimeFormatter.format(LocalDateTime.now()));
	}

}
