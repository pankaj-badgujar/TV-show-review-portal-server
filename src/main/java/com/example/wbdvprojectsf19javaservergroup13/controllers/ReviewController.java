package com.example.wbdvprojectsf19javaservergroup13.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvprojectsf19javaservergroup13.models.Review;
import com.example.wbdvprojectsf19javaservergroup13.services.ReviewService;

@RestController
@CrossOrigin("*")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@PostMapping("/api/faculty/{fid}/analysis/{aid}/review")
	public Review createReview(@PathVariable("fid") int fid, @PathVariable("aid") int aid, @RequestBody Review review) {
		
		return service.createReview(review, fid, aid);
	}
	
	@DeleteMapping("/api/review/{rid}")
	public void deleteReview(@PathVariable("rid") int id) {
		
		service.deleteReview(id);
	}
	
	@PutMapping("/api/review/{rid}")
	public Review updateReview(@PathVariable("rid") int id, @RequestBody Review review) {
		
		return service.updateReview(review, id);
	}
	
	@GetMapping("/api/faculty/{fid}/analysis/{aid}/review")
	public Review getReviewForAnalysisByFaculty(@PathVariable("fid") int fid, @PathVariable("aid") int aid) {
		
		return service.getReviewForAnalysisByFaculty(fid, aid);
	}
}
