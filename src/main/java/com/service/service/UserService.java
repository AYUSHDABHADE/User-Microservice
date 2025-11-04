package com.service.service;

import java.util.List;

import com.service.model.User;

public interface UserService {

	  public User saveUser(User user);
	  
	  public List<User> getAllUser();
	  
	  public User getUserFindByid(Integer id);
}
