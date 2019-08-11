package com.example.wbdvprojectsf19javaservergroup13.controllers;

import com.example.wbdvprojectsf19javaservergroup13.models.Faculty;
import com.example.wbdvprojectsf19javaservergroup13.models.User;
import com.example.wbdvprojectsf19javaservergroup13.services.FacultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(allowCredentials = "true")
public class FacultyController {

  @Autowired
  private FacultyService facultyService;

  @PostMapping("/registerFaculty")
  public void register(@RequestBody Faculty faculty, HttpSession session) {
    facultyService.registerFaculty(faculty);
  }

  @GetMapping("/faculties")
  public List<Faculty> findAllFaculties(){
    return facultyService.findAllFaculties();
  }

  @GetMapping("/findFaculty/{fid}")
  public   Faculty findFacultyById(@PathVariable("fid") Integer fid){
    return facultyService.findFacultyById(fid);
  }

  @GetMapping("/findFaculty")
  public Faculty findFacultyByUser(@RequestBody User user){
    return facultyService.findFacultyByUser(user);
  }
}
