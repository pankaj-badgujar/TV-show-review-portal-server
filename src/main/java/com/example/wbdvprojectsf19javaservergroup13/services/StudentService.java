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

  public Student findStudentByUser(User user){
    return studentRepository.findStudentByUser(user);
  }

  public List<Student> findAllByFaculty(Faculty faculty){
    return studentRepository.findAllByFaculty(faculty);
  }

}
