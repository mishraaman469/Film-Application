package com.mt.film.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.film.entity.Film;
import com.mt.film.exception.FilmNameNotFound;
import com.mt.film.service.FilmService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/film")
public class FilmController {

		@Autowired
		private FilmService filmService;
		
		@GetMapping("/getFilm")	
		public ResponseEntity<List<Film>> getAllFilm() throws FilmNameNotFound{
			log.info("save method is going to call");
			List<Film> film= this.filmService.getAllFilm();
			if(film.isEmpty()) {
				throw new FilmNameNotFound("List of film should not be empty");
			}
			
			log.info("Retrieving data");
			return new ResponseEntity<List<Film>>(film,HttpStatus.OK);
		}
		
		@PostMapping("/saveFilm")
		public ResponseEntity<Void> saveFilm(@RequestBody Film film) throws FilmNameNotFound {
			System.out.println(film.getDirector());
			if(film.getName().equals("")||film.getName()==null || film.getBoxOfficeCollection()==0||film.getRating()==0 ) {
				log.error("Some Error occurred");
				throw new FilmNameNotFound("Should not be empty");
			}
			log.info("Going to save"+film.getName());	
			this.filmService.saveFilm(film);
			log.info("save successfully"+film.getName());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
			
		@DeleteMapping("/deleteFilm/{name}")
		public ResponseEntity<Void> deleteFilm(@PathVariable String name) throws FilmNameNotFound {
			if(name==null || name.equals("")) {
				log.error("Film with this particular name not found");
				throw new FilmNameNotFound("Film with this particular name not found"+name);
			}
			
			log.info("delete is going to call");
			
			this.filmService.deleteFilm(name);
			log.info("Data Deleted"+name);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		@GetMapping("/getFilmByName/{name}")
		public ResponseEntity<Film> getFilm(@PathVariable String name) throws FilmNameNotFound {
			log.info("In controler");
			if(name==null || name.equals("")) {
				log.error("Film name should not be null ");
				throw new FilmNameNotFound("Film with this particular name not found"+name);
			}
			log.info("Get By Name "+name);
			Film film= this.filmService.getFilm(name);
			
			return new ResponseEntity<Film>(film,HttpStatus.OK);
		}
		
}
