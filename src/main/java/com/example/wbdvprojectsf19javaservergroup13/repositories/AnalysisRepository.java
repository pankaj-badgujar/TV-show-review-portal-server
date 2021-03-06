package com.example.wbdvprojectsf19javaservergroup13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.wbdvprojectsf19javaservergroup13.models.Analysis;
import com.example.wbdvprojectsf19javaservergroup13.models.Episode;
import com.example.wbdvprojectsf19javaservergroup13.models.Show;

public interface AnalysisRepository extends CrudRepository<Analysis, Integer> {

	@Query("select analysis From Analysis analysis where analysis.id=:cid")
	public Analysis findAnalysisById(@Param("cid") Integer id);
	
	@Query("select analysis From Analysis analysis where analysis.student.id=:sid")
	public List<Analysis> getAllAnalysisForStudentId(@Param("sid") Integer id);
	

	@Query("select analysis From Analysis analysis where analysis.student.id=:sid AND analysis.episode.id=:eid AND analysis.episode.showId=:showid")
	public Analysis getAnalysisForStudent(@Param("sid") Integer sid,@Param("showid") Integer showid,@Param("eid") Integer eid);

	@Query("select DISTINCT analysis.show From Analysis analysis where analysis.student.user.id=:sid")
	public List<Show> getAllShowForStudentId(@Param("sid") Integer id);

	@Query("select analysis From Analysis analysis where analysis.student.id=:sid AND analysis.episode.id=:eid")
	public List<Analysis> getAnalysisForStudent(@Param("sid") Integer sid,@Param("eid") Integer eid);

	
	@Query("select analysis From Analysis analysis where analysis.student.id=:sid AND analysis.episode.id=:eid AND analysis.episode.showId=:showid")
	public List<Analysis> getAnalysisListForProfessor(@Param("sid") Integer sid,@Param("showid") Integer showid,@Param("eid") Integer eid);


	@Query("select analysis from Analysis analysis")
	public List<Analysis> getAllAnalysis();

	@Query("select analysis from Analysis analysis where analysis.episode.id =:episodeId ")
	public List<Analysis> getAllAnalysisForEpisode(@Param("episodeId") int episodeId);

	@Query("select DISTINCT analysis.show from Analysis analysis where analysis.student.faculty.user.id = :facultyId")
	public List<Show> getAllAnalysisByFaculty(@Param("facultyId") int facultyId);



}
