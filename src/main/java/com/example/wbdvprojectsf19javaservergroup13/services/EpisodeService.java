package com.example.wbdvprojectsf19javaservergroup13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wbdvprojectsf19javaservergroup13.models.Episode;
import com.example.wbdvprojectsf19javaservergroup13.repositories.EpisodeRepository;

@Service
public class EpisodeService {

	@Autowired
	private EpisodeRepository repo;
	
	public Episode createEpisode(Episode episode) {
		
		return repo.save(episode);
	}
}
