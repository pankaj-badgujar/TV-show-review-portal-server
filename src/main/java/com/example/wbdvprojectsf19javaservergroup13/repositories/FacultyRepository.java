package com.example.wbdvprojectsf19javaservergroup13.repositories;

import com.example.wbdvprojectsf19javaservergroup13.models.Faculty;
import com.example.wbdvprojectsf19javaservergroup13.models.User;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacultyRepository  extends CrudRepository<Faculty, Integer> {

  @Query("select faculty from Faculty  faculty")
  List<Faculty> findAllFaculties();

  Faculty findFacultyById(Integer id);

  Faculty findFacultyByUser(User user);
}
