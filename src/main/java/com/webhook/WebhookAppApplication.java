package com.webhook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.webhook.*","com.webhook.mapper"})
public class WebhookAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebhookAppApplication.class, args);
	}
	

}
