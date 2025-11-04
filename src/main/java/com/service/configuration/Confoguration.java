package com.service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class Confoguration {
   @Bean
   @LoadBalanced
	public RestTemplate restconfig() {
		return new RestTemplate();
	}
}
