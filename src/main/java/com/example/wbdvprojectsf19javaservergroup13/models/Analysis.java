package com.example.wbdvprojectsf19javaservergroup13.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="analyses")
public class Analysis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Episode episode;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "submitted")
	private Date dateOfSubmission;

	@ManyToOne
	@JsonIgnore
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private String content;

	@OneToOne
	private Show show;

	public Analysis(int id, String content) {
		super();
		this.id = id;
		this.content = content;

	}

	public Analysis() {
		super();

	}
	
	public Analysis set(Analysis analysis) {
		
		this.content = analysis.content;
		this.episode = analysis.episode;
		this.student = analysis.student;

		return this;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Episode getEpisode() {
		return episode;
	}
	
	@Transient
	public int getEpisodeId() {
		return episode.getId();
	}
	
	@Transient
	public int getUserIdOfStudent() {
		return student.getUser().getId();
	}
	
	@Transient
	public String getStudentsFullName() {
		return student.getUser().getFirstName()+ " " + student.getUser().getLastName();
	}


	public void setEpisode(Episode episode) {
		this.episode = episode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	

	public Date getDateOfSubmission() {
		return dateOfSubmission;
	}

	public void setDateOfSubmission(Date dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}


}