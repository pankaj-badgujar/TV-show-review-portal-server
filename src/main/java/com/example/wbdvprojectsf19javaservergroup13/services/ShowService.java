package com.example.wbdvprojectsf19javaservergroup13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wbdvprojectsf19javaservergroup13.models.Show;
import com.example.wbdvprojectsf19javaservergroup13.repositories.ShowRepository;

@Service
public class ShowService {

	@Autowired
	ShowRepository showRepository;
	
	public Show createShow(Show show) {
		showRepository.save(show);
		return show;
	}
}
