package com.example.wbdvprojectsf19javaservergroup13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.wbdvprojectsf19javaservergroup13.models.Analysis;
import com.example.wbdvprojectsf19javaservergroup13.models.Episode;

public interface AnalysisRepository extends CrudRepository<Analysis, Integer> {

	@Query("select analysis From Analysis analysis where analysis.id=:aid")
	public Analysis findAnalysisById(@Param("cid") Integer id);
	
	@Query("select analysis From Analysis analysis where analysis.student.id=:sid")
	public List<Analysis> getAllAnalysisForStudentId(@Param("sid") Integer id);
	
	@Query("select analysis From Analysis analysis where analysis.student.id=:sid && analysis.episode.id=:eid")
	public Analysis getAnalysisForStudent(@Param("sid") Integer sid,@Param("showid") Integer showid,@Param("eid") Integer eid);
	
	@Query("select analysis From Analysis analysis where analysis.student.id=:sid && analysis.episode.id=:eid")
	public List<Analysis> getAnalysisListForProfessor(@Param("sid") Integer sid,@Param("showid") Integer showid,@Param("eid") Integer eid);
}
