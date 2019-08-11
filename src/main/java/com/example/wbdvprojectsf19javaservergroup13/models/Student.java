package com.example.wbdvprojectsf19javaservergroup13.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JsonIgnore
  private Faculty faculty;

  @OneToMany(mappedBy = "student")
  private List<Analysis> analysisList;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Faculty getFaculty() {
    return faculty;
  }

  public void setFaculty(Faculty faculty) {
    this.faculty = faculty;
  }

  public List<Analysis> getAnalysisList() {
    return analysisList;
  }

  public void setAnalysisList(List<Analysis> analysisList) {
    this.analysisList = analysisList;
  }
}
