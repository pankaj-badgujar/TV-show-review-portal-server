package com.example.wbdvprojectsf19javaservergroup13.controllers;

import com.example.wbdvprojectsf19javaservergroup13.models.Faculty;
import com.example.wbdvprojectsf19javaservergroup13.models.Student;
import com.example.wbdvprojectsf19javaservergroup13.models.User;
import com.example.wbdvprojectsf19javaservergroup13.services.FacultyService;
import com.example.wbdvprojectsf19javaservergroup13.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @PostMapping("/registerStudent")
  public void register(@RequestBody Student student) {
    studentService.registerStudent(student);
  }
  
  @PutMapping("/enroll/{userId}")
  public Student enrollUnderFaculty(@PathVariable("userId") int userId,@RequestBody Faculty faculty) {
	return studentService.enrollUnderFaculty(userId, faculty);  
  }
  
  @DeleteMapping("/cancelEnrollment/{userId}")
  public Student cancelEnrollment(@PathVariable("userId") int userId) {
	  return studentService.cancelEnrollment(userId);
  }

  @GetMapping("/students")
  public List<Student> findAllStudents(){
    return studentService.findAllStudents();
  }

  @GetMapping("/findStudent/{sid}")
  public   Student findStudentById(@PathVariable("sid") Integer sid){
    return studentService.findStudentById(sid);
  }
  
  @GetMapping("/findFacultyOfStudent/{userId}")
  public   Faculty findFacultyByUserIdOfStudent(@PathVariable("userId") Integer userId){
    return studentService.findFacultyByUserIdOfStudent(userId);
  }
  

}
