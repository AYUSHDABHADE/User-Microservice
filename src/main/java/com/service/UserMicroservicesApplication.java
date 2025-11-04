package com.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient

public class UserMicroservicesApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(UserMicroservicesApplication.class, args);
		System.err.println("Application is running...");
	}

}

