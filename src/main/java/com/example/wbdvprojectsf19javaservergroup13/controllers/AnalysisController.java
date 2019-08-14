package com.example.wbdvprojectsf19javaservergroup13.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvprojectsf19javaservergroup13.models.Analysis;
import com.example.wbdvprojectsf19javaservergroup13.models.Show;
import com.example.wbdvprojectsf19javaservergroup13.services.AnalysisService;

@RestController
@CrossOrigin(allowCredentials = "true")
public class AnalysisController {

	@Autowired
	private AnalysisService service;
	
	@PostMapping("/api/user/{userid}/tvshow/{showid}/episode/{eid}/analysis")
	public Analysis createAnalysis(@RequestBody Analysis analysis) {
		
		return service.createAnalysis(analysis);
	}
	
	@GetMapping("/api/user/{userid}/tvshow/{showid}/episode/{eid}/analysis")
	public Analysis getAnalysisForStudent(@PathVariable("userid") int userId, @PathVariable("showid") int showId, @PathVariable("eid") int eid) {
		
		return service.getStudentAnalysisList(userId, showId, eid);
	}
//
//	@GetMapping("/api/user/{userid}/tvshow/{showid}/episode/{eid}/analysis")
//	public List<Analysis> getAnalysisForProfessor(@PathVariable("userid") int userId, @PathVariable("showid") int showId, @PathVariable("eid") int eid) {
//
//		return service.getAnalysisListForProfessor(userId, showId, eid);
//	}
//
	@GetMapping("/api/user/{userid}/analysis") 
	public List<Analysis> getAllAnalysisForStudent(@PathVariable("userid") int userid) {
		
		return service.getAllAnalysisForStudentId(userid);
	}
	
	@PutMapping("/api/user/{userid}/tvshow/{showid}/episode/{eid}/analysis/{aid}")
	public Analysis updateAnalysis(@RequestBody Analysis analysis, @PathVariable("aid") int aid) {
		
		return service.updateAnalysis(analysis,aid);
	}
	
	@DeleteMapping("/api/user/{userid}/tvshow/{showid}/episode/{eid}/analysis/{aid}")
	public void deleteAnalysis( @PathVariable("aid") int aid) {
		
		 service.deleteAnalysis(aid);
	}

//	@GetMapping("/api/user/latestAnalysis")
//	public List<Analysis> getLatestAnalysis() {
//
//		return service.getLatestAnalysis();
//	}

	@GetMapping("api/user/analysedAhowIds/{sid}")
	public List<Show> getAnalysedShows(@PathVariable("sid") int sid){
		return service.getAnalysedShows(sid);
		}

}
