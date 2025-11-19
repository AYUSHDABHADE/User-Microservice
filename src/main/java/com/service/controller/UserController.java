package com.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.model.User;
import com.service.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	 private static final Logger log = LoggerFactory.getLogger(UserService.class);
	@PostMapping("/saveDetails")
	public User saveUserDetails(@RequestBody User user) {
		User use = userService.saveUser(user);
		return use;
	}

	@GetMapping

	public List<User> getAllUser() {
		List<User> list = userService.getAllUser();
		return list;
	}
	
	  
      @GetMapping("/getdata/{id}")
 //     @CircuitBreaker(name="ratingHotelBreaker" , fallbackMethod = "rateingHotelFallback")
 //     @Retry(name="HotelService", fallbackMethod = "rateingHotelFallback")
      @RateLimiter(name="userRateLimiter", fallbackMethod = "rateingHotelFallback")
	public User getById(@PathVariable("id") Integer id) {
    	  int retryCount=1;
		User usa = userService.getUserFindByid(id);
		  retryCount++;
		  log.info("Retry Count::"+retryCount);
		  System.err.println("retry count::"+retryCount);
		return usa;
	}
      
      // creating fall back method for circuit breaker if service is down then it will be executed
      public User rateingHotelFallback(Integer id , Throwable ex) {
    	     log.info("Fallback is executed because Service is down", ex.getMessage());
    	     log.info("i am inside the rateingHotelFallback methods");
    	     System.out.println("now follback method is running");
    	  return new User(10,"Dummy","Dummy address", "Rateing Service is down now");
      }
 	
    
  
}
