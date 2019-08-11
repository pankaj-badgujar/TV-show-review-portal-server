package com.example.wbdvprojectsf19javaservergroup13.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.wbdvprojectsf19javaservergroup13.models.Episode;
import com.example.wbdvprojectsf19javaservergroup13.repositories.EpisodeRepository;

public class EpisodeService {

	@Autowired
	private EpisodeRepository repo;
	
	public Episode createEpisode(Episode episode) {
		
		return repo.save(episode);
	}
}
