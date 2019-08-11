package com.example.wbdvprojectsf19javaservergroup13.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculties")
public class Faculty {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private List<Student> studentList;

  private User user;


}
