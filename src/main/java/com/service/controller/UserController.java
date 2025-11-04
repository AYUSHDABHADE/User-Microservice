package com.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.model.User;
import com.service.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/saveDetails")
	public User saveUserDetails(@RequestBody User user) {
		User use = userService.saveUser(user);
		return use;
	}

	@GetMapping("/getAll")
	public List<User> getAllUser() {
		List<User> list = userService.getAllUser();
		return list;
	}
      @GetMapping("/getdata/{id}")
	public User getById(@PathVariable("id") Integer id) {
		User usa = userService.getUserFindByid(id);
		return usa;
	}
}
