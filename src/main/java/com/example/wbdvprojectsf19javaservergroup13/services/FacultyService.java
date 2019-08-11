package com.example.wbdvprojectsf19javaservergroup13.services;


import com.example.wbdvprojectsf19javaservergroup13.models.Faculty;
import com.example.wbdvprojectsf19javaservergroup13.models.User;
import com.example.wbdvprojectsf19javaservergroup13.repositories.FacultyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

  @Autowired
  public FacultyRepository facultyRepository;

  public void registerFaculty(Faculty faculty){
    facultyRepository.save(faculty);
  }

  public List<Faculty> findAllFaculties(){
    return facultyRepository.findAllFaculties();
  }

  public   Faculty findFacultyById(Integer id){
    return facultyRepository.findFacultyById(id);
  }

  public Faculty findFacultyByUser(User user){
    return facultyRepository.findFacultyByUser(user);
  }
}
