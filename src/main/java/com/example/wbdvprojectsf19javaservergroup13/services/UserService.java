package com.example.wbdvprojectsf19javaservergroup13.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wbdvprojectsf19javaservergroup13.models.User;
import com.example.wbdvprojectsf19javaservergroup13.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	public User register(User user) {
		userRepository.save(user);
		return user;
	}
	
	public User findUserByCredentials(User user) {
		return userRepository.findUserByCredentials(user.getUsername(),user.getPassword());
	}
	
	public User findUserById(int id) {
		System.out.println("heres id: "+ id);
		return userRepository.findById(id).get();
	}
	
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

	public User updateUser(int userId, User user) {
		User userToBeUpdated = userRepository.findById(userId).get();
		userToBeUpdated.setFirstName(user.getFirstName());
		userToBeUpdated.setLastName(user.getLastName());
		userToBeUpdated.setUsername(user.getUsername());
		userToBeUpdated.setPassword(user.getPassword());
		
		userRepository.save(userToBeUpdated);
		return userToBeUpdated;
	}

}
