/**
 * 
 */
package com.example.wbdvprojectsf19javaservergroup13.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wbdvprojectsf19javaservergroup13.models.Analysis;
import com.example.wbdvprojectsf19javaservergroup13.models.Faculty;
import com.example.wbdvprojectsf19javaservergroup13.models.Review;
import com.example.wbdvprojectsf19javaservergroup13.repositories.AnalysisRepository;
import com.example.wbdvprojectsf19javaservergroup13.repositories.FacultyRepository;
import com.example.wbdvprojectsf19javaservergroup13.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repo;
	
	@Autowired
	AnalysisRepository arepo;
	
	@Autowired
	FacultyRepository frepo;
	
	public Review createReview(Review review, int fid, int aid) {
		
		Analysis analysis = arepo.findAnalysisById(aid);
		Faculty faculty = frepo.findFacultyById(fid);
		System.out.print(analysis);
		System.out.print(faculty);
		if (analysis != null && faculty != null) {
		review.setAnalysis(analysis);
		review.setFaculty(faculty);
		return repo.save(review);
		}
		else {
			return null;
		}
	}
	
	public Review getReviewById(int rid) {
		
		return repo.findReviewsById(rid);
	}
	
	public Review getReviewForAnalysisByFaculty(int fId, int aId) {
		
		return repo.getReviewForAnalysisIdAndFacultyId(aId, fId);
	}
	
	public Review updateReview(Review review, int rid) {
		
		Review old = repo.findReviewsById(rid);
		old.set(review);
		repo.save(old);
		return repo.findReviewsById(rid);
	}
	
	public void deleteReview(int rid) {
		
		repo.delete(repo.findReviewsById(rid));
	}
}
