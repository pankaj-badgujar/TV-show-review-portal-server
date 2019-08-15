package com.example.wbdvprojectsf19javaservergroup13.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reviews")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float grade;
	private String feedback;
	
	@OneToOne
	@JsonIgnore
	private Analysis analysis;

	@ManyToOne
	@JsonIgnore
	private Faculty faculty;

	public Review(int id, float grade) {
		super();
		this.id = id;
		this.grade = grade;
	}
	
	public Review(int id, float grade, String feedback) {
		super();
		this.id = id;
		this.grade = grade;
		this.feedback = feedback;
	}
	
	public int getId() {
		return id;
	}
	
	@Transient
	public int getUserIdOfFaculty() {
		return faculty.getUser().getId();
	}
	
	@Transient
	public String getFacultyFullName() {
		return faculty.getUser().getFirstName()+ " " + faculty.getUser().getLastName();
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}

	public Review() {
		super();
	}
	
	public Review set(Review review) {
		
		this.grade = review.grade;
		this.analysis = review.analysis;
		this.feedback = review.feedback;
		this.faculty = review.faculty;
		return this;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
}