package com.example.wbdvprojectsf19javaservergroup13.services;

import com.example.wbdvprojectsf19javaservergroup13.models.Faculty;
import com.example.wbdvprojectsf19javaservergroup13.models.Student;
import com.example.wbdvprojectsf19javaservergroup13.models.User;
import com.example.wbdvprojectsf19javaservergroup13.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


  @Autowired
  public StudentRepository studentRepository;

  public void registerStudent(Student student){
    studentRepository.save(student);
  }

  public List<Student> findAllStudents(){
    return studentRepository.findAllStudents();
  }

  public Student findStudentById(Integer id){
    return studentRepository.findStudentById(id);
  }

//  public Student findStudentByUser(User user){
//    return studentRepository.findStudentByUser(user);
//  }

  public List<Student> findAllByFaculty(Faculty faculty){
    return studentRepository.findAllByFaculty(faculty);
  }
  
  public Student findStudentByUserId(int userId) {
	  return studentRepository.findStudentByUserId(userId);
  }

  public Student enrollUnderFaculty(int userId,Faculty faculty) {
	  Student studentToBeEnrolled = this.findStudentByUserId(userId);
	  studentToBeEnrolled.setFaculty(faculty);
	  studentRepository.save(studentToBeEnrolled);
	return studentToBeEnrolled;
  }
  
  public Student cancelEnrollment(int userId) {
	  Student studentToBeChanged = this.findStudentByUserId(userId);
	  studentToBeChanged.setFaculty(null);
	  studentRepository.save(studentToBeChanged);
	  return studentToBeChanged;
  }
  
  public Faculty findFacultyByUserIdOfStudent(int userId) {
	  Student studentWhoseFacultyRequired = this.findStudentByUserId(userId);
	  return studentWhoseFacultyRequired.getFaculty();
  }
}
