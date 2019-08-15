package com.example.wbdvprojectsf19javaservergroup13.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wbdvprojectsf19javaservergroup13.models.Analysis;
import com.example.wbdvprojectsf19javaservergroup13.models.Show;

import com.example.wbdvprojectsf19javaservergroup13.models.Episode;
import com.example.wbdvprojectsf19javaservergroup13.models.Student;

import com.example.wbdvprojectsf19javaservergroup13.repositories.AnalysisRepository;
import com.example.wbdvprojectsf19javaservergroup13.repositories.EpisodeRepository;
import com.example.wbdvprojectsf19javaservergroup13.repositories.ShowRepository;
import com.example.wbdvprojectsf19javaservergroup13.repositories.StudentRepository;

@Service
public class AnalysisService {

	@Autowired
	private AnalysisRepository analysisRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EpisodeRepository episodeRepository;
	
	@Autowired
	private ShowRepository showRepository;
	
	public Analysis createAnalysis(int userId, int showId, int episodeId, Analysis analysis) {
		
		Show show = showRepository.findById(showId).get();
		Episode episode = episodeRepository.findById(episodeId).get();
		Student student  = studentRepository.findStudentByUserId(userId);
		
		
		analysis.setShow(show);
		analysis.setEpisode(episode);
		analysis.setStudent(student);
		
		return analysisRepository.save(analysis);
	}
	
	public List<Analysis> getStudentAnalysisList(int userId, int eid) {
		
		Student student = studentRepository.findStudentByUserId(userId);
		return analysisRepository.getAnalysisForStudent(student.getId(),eid);
	}
	
	public List<Analysis> getAnalysisListForProfessor(int userId, int showId, int eid) {
		
		return analysisRepository.getAnalysisListForProfessor(userId,showId,eid);
	}
	
	public List<Analysis> getAllAnalysisForStudentId(int uid) {
		
		return analysisRepository.getAllAnalysisForStudentId(uid);
	}
	
	public Analysis updateAnalysis(int aid, String content) {
		
		Analysis analysisToBeUpdated = analysisRepository.findAnalysisById(aid);
		analysisToBeUpdated.setContent(content);
		analysisRepository.save(analysisToBeUpdated);
		return analysisToBeUpdated;
	}
	
	public void deleteAnalysis(int aid) {
		analysisRepository.deleteById(aid);
	}

	public List<Analysis> getAllAnalysis() {
		return analysisRepository.getAllAnalysis();
	}

	public List<Analysis> getAllAnalysisForEpisode(int episodeId) {
		return analysisRepository.getAllAnalysisForEpisode(episodeId);
	}

//  public List<Analysis> getLatestAnalysis(){
//		return repo.getLatestAnalysis();
//	}

	public List<Show> getAnalysedShows(int sid){
		return analysisRepository.getAllShowForStudentId(sid);
	}
}
