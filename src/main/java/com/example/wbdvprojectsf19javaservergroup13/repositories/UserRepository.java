package com.example.wbdvprojectsf19javaservergroup13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.wbdvprojectsf19javaservergroup13.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("select user from User user where user.username = :uname AND user.password = :pwd")
	User findUserByCredentials(@Param("uname") String username, @Param("pwd") String password);

	@Query("select user from User user")
	List<User> findAllUsers();

}
