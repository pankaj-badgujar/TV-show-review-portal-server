package com.example.wbdvprojectsf19javaservergroup13.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="episodes")
public class Episode {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int showId;
	
	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	@OneToMany(mappedBy= "episode")
	private List<Analysis> analyses;
	
//	@ManyToOne(mappedBy="episode")
//	@JsonIgnore
//	private Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Analysis> getAnalyses() {
		return analyses;
	}

	public void setAnalyses(List<Analysis> analyses) {
		this.analyses = analyses;
	}

	public Episode(int id) {
		super();
		this.id = id;
	}
	
	public Episode() {
		
		super();
	}
	
	public Episode(int id, int showId, List<Analysis> analyses) {
		super();
		this.id = id;
		this.showId = showId;
		this.analyses = analyses;
	}

	public Episode set(Episode episode) {
		
		this.analyses = episode.analyses;
		this.showId = episode.showId;
		return this;
	}
	
	
}