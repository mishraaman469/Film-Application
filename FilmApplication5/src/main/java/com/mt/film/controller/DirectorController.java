package com.mt.film.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.film.entity.Director;
import com.mt.film.entity.Film;
import com.mt.film.exception.DirectorNameNotFound;
import com.mt.film.service.DirectorService;
import com.mt.film.service.FilmService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
@RequestMapping("/dir")
public class DirectorController {
	
	@Autowired
	private DirectorService directorService;
	
	@GetMapping("/getDirector")	
	public ResponseEntity<List<Director>> getAllDirector() throws DirectorNameNotFound{
		
		List<Director> director=this.directorService.getAllDirector();
		if(director.isEmpty()) {
			log.error("Exception occured when empty list is retrieved");
			throw new DirectorNameNotFound("List of directors are empty");
		}
		List<Director> directors=director.stream().sorted(new Director()::compare).collect(Collectors.toList());
		log.info("Retrieving data");
		return new ResponseEntity<List<Director>>(directors,HttpStatus.OK);
	}
	
	@PostMapping("/saveDirector")
	public ResponseEntity<String> saveDirectors(@RequestBody Director director) throws DirectorNameNotFound {
		if(director.getName().equals("")||director.getName()==null || director.getAge()==0 || director.getGender().equals("")|| director.getGender()==null) {
			throw new DirectorNameNotFound("Should not be empty");
		}
		 
		this.directorService.saveDirector(director);
		log.info("save successfully"+director.getName());
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
			
	@PutMapping("/updateDirector/{name}")
	public ResponseEntity<Director> updateDirectors(@RequestBody Director director) throws DirectorNameNotFound {
		if(director.getName().equals("")||director.getName()==null || director.getAge()==0 || director.getAwardCount()==0) {
			throw new DirectorNameNotFound("Should not be empty");
		}
			Director directors=	this.directorService.updateDirector(director);
			log.info("update Successfully for director "+director.getName());
			return new ResponseEntity<Director>(directors,HttpStatus.OK);
	}
	
	@GetMapping("/getDirector/{name}")
	public ResponseEntity<Director> getDirectors(@PathVariable String name) throws DirectorNameNotFound {
		if(name==null || name.equals("")) {
			throw new DirectorNameNotFound("Director with this particular name not found"+name);
		}
		Director director= this.directorService.getDirector(name);
		log.info("Get By Name"+name);
		return new ResponseEntity<Director>(director,HttpStatus.OK);
	}
	
}
