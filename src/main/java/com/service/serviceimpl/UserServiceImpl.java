package com.service.serviceimpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.exception.idisNotFound;
import com.service.model.Hotel;
import com.service.model.Rateing;
import com.service.model.User;
import com.service.repository.UserRepository;
import com.service.service.UserService;

import ch.qos.logback.classic.Logger;

@Service
public class UserServiceImpl implements UserService {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		User use = userRepository.save(user);
		return use;
	}

	@Override
	public List<User> getAllUser() {
		List<User> list = userRepository.findAll();
		return list;
	}

	@Override
	public User getUserFindByid(Integer id) {
		User user = userRepository.findById(id);

		Rateing [] forObject = restTemplate.getForObject("http://RATEINGMICROSERVICE/getdata"+user.getId(), Rateing[].class);
               List<Rateing> rate= Arrays.stream(forObject).toList();
		        user.setSetrate(rate);
		
               logger.info("Logger check for Application"+forObject);
               
              List<Rateing> rateinglist = rate.stream().map(rating ->{
            	   // api call the get the hotel service to get api
            	   
            	  ResponseEntity<Hotel>  forentity=   restTemplate.getForEntity("http://USERMICROSERVICES/getdata/2", Hotel.class);
            	  
            	  Hotel hotel= forentity.getBody();
            	     // set the hotel to rating 
            	       rating.setHotel(hotel);
                    return rating;
               }).collect(Collectors.toList());
                user.setSetrate(rateinglist);
                user.setSetrate(rate);
        		
           		if (user == null) {
			System.out.println("user value is ::" + user);
			throw new idisNotFound("id is not found");
		}
           		
           		
           		
		return user;
	}
}
