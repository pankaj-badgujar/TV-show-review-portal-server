package com.example.wbdvprojectsf19javaservergroup13.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.wbdvprojectsf19javaservergroup13.models.Analysis;
import com.example.wbdvprojectsf19javaservergroup13.repositories.AnalysisRepository;

public class AnalysisService {

	@Autowired
	private AnalysisRepository repo;
	
	public Analysis createAnalysis(Analysis analysis) {
		
		return repo.save(analysis);
	}
	
	public Analysis getStudentAnalysisList(int userId, int showId, int eid) {
		
		return repo.getAnalysisForStudent(userId,showId,eid);
	}
	
	public List<Analysis> getAnalysisListForProfessor(int userId, int showId, int eid) {
		
		return repo.getAnalysisListForProfessor(userId,showId,eid);
	}
	
	public List<Analysis> getAllAnalysisForStudentId(int uid) {
		
		return repo.getAllAnalysisForStudentId(uid);
	}
	
	public Analysis updateAnalysis(Analysis analysis, int aid) {
		
		Analysis old = repo.findAnalysisById(aid);
		old.set(analysis);
		repo.save(old);
		return repo.findAnalysisById(aid);
	}
	
	public void deleteAnalysis(int aid) {
		
		repo.delete(repo.findAnalysisById(aid));
	}
}
