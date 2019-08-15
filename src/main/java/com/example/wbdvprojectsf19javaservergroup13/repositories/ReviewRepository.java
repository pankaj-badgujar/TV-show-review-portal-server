package com.example.wbdvprojectsf19javaservergroup13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.wbdvprojectsf19javaservergroup13.models.Review;
import com.example.wbdvprojectsf19javaservergroup13.models.Show;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

	@Query("select review From Review review where review.id=:rid")
	public Review findReviewsById(@Param("rid") Integer id);
	
	@Query("select review From Review review where review.analysis.id=:aid AND review.faculty.user.id=:fid")
	public Review getReviewForAnalysisIdAndFacultyId(@Param("aid") Integer id, @Param("fid") Integer fid);

	@Query("select DISTINCT review.analysis.show From Review review where review.faculty.user.id=:fid")
	List<Show> getAnalysisReviewdByFaculty(int fid);

	@Query("select review From Review review where review.analysis.id=:aid")
	public Review getReviewForAnalysis(@Param("aid") Integer aid);
}
