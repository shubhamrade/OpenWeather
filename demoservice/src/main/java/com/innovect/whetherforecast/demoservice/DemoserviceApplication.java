package com.innovect.whetherforecast.demoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync
@EnableCaching
public class DemoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoserviceApplication.class, args);
	}

}
