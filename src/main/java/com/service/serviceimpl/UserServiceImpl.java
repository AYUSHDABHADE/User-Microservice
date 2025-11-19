package com.service.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.model.Hotel;
import com.service.model.Rateing;
import com.service.model.User;
import com.service.repository.UserRepository;
import com.service.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserServiceImpl implements UserService {

	private org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
              
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
//	@Autowired
//     private HotelService hotelService;
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

	// we will get single user based on id we need to call the rating service
	@Override
	  
	public User getUserFindByid(Integer id) {
		User user = userRepository.findById(id);
		// get the rating service about the user
		// url : http://localhost:9090/users/1
   // "http://RATEINGMICROSERVICE/ratings/users/" + id, Rateing[].class
	// "http://RATEINGMICROSERVICE/users/1"	
		Rateing[] ratingOfUserdata = restTemplate.getForObject("http://RATEINGMICROSERVICE/ratings/users/"+id , Rateing[].class
				);
		
		List<Rateing> rateings=Arrays.stream(ratingOfUserdata).toList();

		List<Rateing> ratinglist = rateings.stream().map(rating -> {
			// api call to hotel service get the hotel service                    we are using dynamic id get though the id
			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELMICROSERVICE/hotels/getbyid/1", Hotel.class);
			Hotel hotel = forEntity.getBody();
			
			  System.err.println("Hotel response"+forEntity);
			  log.info("i am inside the getUserFindById method"+forEntity);
			log.info("Response status code:", forEntity.getStatusCode());
			// set hotel to rating
			// return the rating
			// return rating 
			rating.setHotel(hotel);
			return rating;

		}).collect(Collectors.toList());
		user.setSetrate(ratinglist);

//			if (user == null) {
//			System.out.println("user value is ::" + user);
//			throw new idisNotFound("id is not found");
//		}
		return user;

	}
	
}
