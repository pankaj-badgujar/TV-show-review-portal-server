package com.example.wbdvprojectsf19javaservergroup13.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

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
@CrossOrigin(allowCredentials = "true")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user, HttpSession session) {
		User currentUser =  userService.register(user);
		session.setAttribute("current user", currentUser);
		return currentUser;
	}
	
	@GetMapping("/checkLogin")
	public User checkLogin(HttpSession session) {	
		return (User)session.getAttribute("current user");
	}
	
	@PostMapping("/login")
	public User findUserByCredentials(@RequestBody User user, HttpSession session) {
		User currentUser= userService.findUserByCredentials(user); 
		session.setAttribute("current user", currentUser);
		return currentUser; 
	}
	
	@GetMapping("/logout")
	public void logout(HttpSession session) {
		session.invalidate();
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
