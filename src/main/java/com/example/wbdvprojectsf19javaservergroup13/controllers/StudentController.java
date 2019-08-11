package com.example.wbdvprojectsf19javaservergroup13.controllers;

import com.example.wbdvprojectsf19javaservergroup13.models.Faculty;
import com.example.wbdvprojectsf19javaservergroup13.models.Student;
import com.example.wbdvprojectsf19javaservergroup13.models.User;
import com.example.wbdvprojectsf19javaservergroup13.services.FacultyService;
import com.example.wbdvprojectsf19javaservergroup13.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@CrossOrigin(allowCredentials = "true")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @PostMapping("/registerStudent")
  public void register(@RequestBody Student student) {
    studentService.registerStudent(student);
  }

  @GetMapping("/students")
  public List<Student> findAllFaculties(){
    return studentService.findAllStudents();
  }

  @GetMapping("/findStudent/{sid}")
  public   Student findFacultyById(@PathVariable("sid") Integer sid){
    return studentService.findStudentById(sid);
  }

  @GetMapping("/findStudent")
  public Student findFacultyByUser(@RequestBody User user){
    return studentService.findStudentByUser(user);
  }
}
