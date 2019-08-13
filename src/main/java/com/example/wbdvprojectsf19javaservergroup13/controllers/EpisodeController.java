package com.example.wbdvprojectsf19javaservergroup13.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvprojectsf19javaservergroup13.models.Episode;
import com.example.wbdvprojectsf19javaservergroup13.repositories.EpisodeRepository;
import com.example.wbdvprojectsf19javaservergroup13.services.EpisodeService;

@RestController
@CrossOrigin("*")
public class EpisodeController {

	@Autowired
	private EpisodeService service;
	
//	@PostMapping("/api/user/{userid}/tvshow/{showid}/episode")
	@PostMapping("/api/episode")
	public Episode addEpisode(@RequestBody Episode episode) {
		return service.createEpisode(episode);
	}

	@GetMapping("/api/episode/{episodeId}")
	public Episode getEpisodeById(@PathVariable("episodeId") int episodeId) {
		return service.getEpisodeById(episodeId);
	}
	
//	@GetMapping("/api/user/{userid}/tvshow/{showid}/episode/")
//	public List<Episode> getEpisodes() {
//		
//		return service.getEpisode(@PathVariable("userid") userId, )
//	}
	
}
