package com.gustavo.smartcitynoisemonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SmartCityNoiseMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartCityNoiseMonitoringApplication.class, args);
	}

}
