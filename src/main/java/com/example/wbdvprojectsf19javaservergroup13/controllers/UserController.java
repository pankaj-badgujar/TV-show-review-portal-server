package com.example.wbdvprojectsf19javaservergroup13.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvprojectsf19javaservergroup13.models.User;
import com.example.wbdvprojectsf19javaservergroup13.services.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/users")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}
	
	@PutMapping("/api/users")
	public User findUserByCredentials(@RequestBody User user) {
		return userService.findUserByCredentials(user);
	}
	
	@GetMapping("/api/users/{id}")
	public User findUserById(@PathVariable("id") int id) {
		return userService.findUserById(id);
	}
	
	@GetMapping("/api/users")
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}

}
