package com.service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class ConfigurationCode {
   @Bean
   @LoadBalanced
	public RestTemplate restconfig() {
		return new RestTemplate();
	}
}
