package com.example.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class DemoServicePropertiesExample {
	
	@Scheduled(cron = "${cron.expression}")
    public void demoServiceMethod()
    {
        System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
    }
	
}
