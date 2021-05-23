package com.mt.film.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mt.film.entity.Director;
import com.mt.film.entity.Film;
import com.mt.film.exception.DirectorNameNotFound;
import com.mt.film.exception.FilmNameNotFound;
import com.mt.film.service.DirectorService;

@SpringBootTest
class DirectorControllerTest {

	@Mock
	DirectorService directorService;
	
	@InjectMocks
	DirectorController directorController;
	
	
	@Test
	void test() throws DirectorNameNotFound { 
		List<Director> directors=new ArrayList<>();
		directors.add(new Director(1,"Aman",(byte)22,"male",(byte)4,null));
		directors.add(new Director(2,"Shubham",(byte)23,"male",(byte)4,null));
		directors.add(new Director(3,"Varshini",(byte)12,"female",(byte)4,null));
		ResponseEntity<List<Director>> response=new ResponseEntity<>(directors, HttpStatus.OK);
		when(directorService.getAllDirector()).thenReturn(directors);
		assertEquals(response,directorController.getAllDirector());
	}
	
	
	@Test
	void exceptionGetTest() {
		assertThrows(DirectorNameNotFound.class, ()->directorController.getAllDirector());
	}
	
	@Test
	void exceptionPostTest() {
		Director directors=new Director();
		directors.setId(4);
		directors.setName("");
		directors.setAge((byte)32);
		directors.setGender("male");
		directors.setAwardCount((byte)4);
		directors.setFilm(null);
		assertThrows(DirectorNameNotFound.class, ()->directorController.saveDirectors(directors));
	}
	

	@Test
	void exceptionUpdateTest() {
		Director directors=new Director();
		directors.setId(4);
		directors.setName("");
		directors.setAge((byte)32);
		directors.setGender("male");
		directors.setAwardCount((byte)4);
		directors.setFilm(null);
		assertThrows(DirectorNameNotFound.class, ()->directorController.updateDirectors(directors));
	}
	
	@Test
	void exceptionGetByNameTest() {
		String name="";
		assertThrows(DirectorNameNotFound.class, ()->directorController.getDirectors(name));
	}
	
	@Test
	void postTest() throws DirectorNameNotFound {
		//Director directors=new Director(4,"Akhilesh",(byte)32,"male",(byte)4,null);
		Director directors=new Director();
		directors.setId(4);
		directors.setName("Akhilesh");
		directors.setAge((byte)32);
		directors.setGender("male");
		directors.setAwardCount((byte)4);
		directors.setFilm(null);
		
		doNothing().when(directorService).saveDirector(directors);
		directorController.saveDirectors(directors);
		verify(directorService,times(1)).saveDirector(directors);
	}
	
	@Test
	void updateTest() throws DirectorNameNotFound {
		String name="Aman";
		Director director=new Director(4,"Akhilesh",(byte)32,"male",(byte)4,null);
		Director directors=new Director(4,"Akhilesh",(byte)32,"male",(byte)4,null);
		ResponseEntity<Director> response=new ResponseEntity<>(director,HttpStatus.OK);
		when(directorService.updateDirector(director)).thenReturn(director);
		assertEquals(response,directorController.updateDirectors(director));
	}
	
	@Test
	void getDirectorByName() throws DirectorNameNotFound {
		String name="Aman";
		//Director director=new Director(1,"Aman",(byte)23,"male",(byte)5,null);
		Director director=new Director();
		director.setId(4);
		director.setName("Aman");
		director.setAge((byte)32);
		director.setGender("male");
		director.setAwardCount((byte)4);
		director.setFilm(null);
		ResponseEntity<Director> response=new ResponseEntity<>(director, HttpStatus.OK);
		when(directorService.getDirector(name)).thenReturn(director);
		assertEquals(response,directorController.getDirectors(name));
	}

}
