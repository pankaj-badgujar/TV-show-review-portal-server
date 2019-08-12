package com.example.wbdvprojectsf19javaservergroup13.repositories;

import com.example.wbdvprojectsf19javaservergroup13.models.Faculty;
import com.example.wbdvprojectsf19javaservergroup13.models.User;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacultyRepository  extends CrudRepository<Faculty, Integer> {

  @Query("select faculty from Faculty  faculty")
  List<Faculty> findAllFaculties();

  Faculty findFacultyById(Integer id);

  @Query("select faculty from Faculty faculty where faculty.user.id =:userId")
  Faculty findFacultyByUser(@Param("userId") int userId);
}
