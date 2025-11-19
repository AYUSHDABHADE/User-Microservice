package com.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserMicroservicesApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(UserMicroservicesApplication.class, args);
		System.err.println("Application is running...");
	}

}

