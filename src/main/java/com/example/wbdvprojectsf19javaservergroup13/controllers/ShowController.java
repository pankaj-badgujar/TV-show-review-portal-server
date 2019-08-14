package com.example.wbdvprojectsf19javaservergroup13.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvprojectsf19javaservergroup13.models.Show;
import com.example.wbdvprojectsf19javaservergroup13.services.ShowService;

@RestController
@CrossOrigin("*")
public class ShowController {
	
	@Autowired
	ShowService showService;
	
	@PostMapping("/api/show")
	public Show createShow(@RequestBody Show show) {
		return showService.createShow(show);
	}

}
