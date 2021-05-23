package com.mt.film.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mt.film.entity.Director;
import com.mt.film.entity.Film;
import com.mt.film.exception.FilmNameNotFound;
import com.mt.film.service.DirectorService;
import com.mt.film.service.FilmService;

@SpringBootTest
class FilmControllerTest {


	@Mock
	FilmService filmService;
	
	@InjectMocks
	FilmController filmController;
	
	
	@Test
	void test() throws FilmNameNotFound {
		List<Film> film=new ArrayList<>();
		film.add(new Film(1,"Avenger",3000,(byte)5,null));
		film.add(new Film(2,"batman",4000,(byte)4,null));
		ResponseEntity<List<Film>> response=new ResponseEntity<>(film,HttpStatus.OK);
		
		when(filmService.getAllFilm()).thenReturn(film);
		assertEquals(response,filmController.getAllFilm());
		
		List<Film> filmy=new ArrayList<>();
	//	ResponseEntity<List<Film>> response1=new ResponseEntity<>(filmy,HttpStatus.OK);
		
		when(filmService.getAllFilm()).thenReturn(film);
		try {
			filmController.getAllFilm();
		}catch(Exception e) {
			assertTrue(e instanceof FilmNameNotFound);
		}
	
	}
	
	@Test
	void exceptionGetTest() {
		assertThrows(FilmNameNotFound.class, ()->filmController.getAllFilm());
	}
	
	@Test
	void exceptionPostTest() {
		Film film=new Film();
		film.setId(2);
		film.setName("");
		film.setRating((byte)4);
		film.setBoxOfficeCollection(4000);
		film.setDirector(null);
		//doNothing().when(filmService).saveFilm(film);
		assertThrows(FilmNameNotFound.class, ()->filmController.saveFilm(film));
	}
	
	@Test
	void exceptionDeleteTest() {
		String name="";
		assertThrows(FilmNameNotFound.class, ()->filmController.deleteFilm(name));
	}
	
	@Test
	void exceptionGetByNameTest() {
		String name="";
		assertThrows(FilmNameNotFound.class, ()->filmController.getFilm(name));
	}
	
	@Test
	void postTest() throws FilmNameNotFound {
		//Film film=new Film(2,"batman",4000,(byte)4,null);
		Film film=new Film();
		film.setId(2);
		film.setName("batman");
		film.setRating((byte)4);
		film.setBoxOfficeCollection(4000);
		film.setDirector(null);
		doNothing().when(filmService).saveFilm(film);
		filmController.saveFilm(film);
		verify(filmService,times(1)).saveFilm(film);
	}
	
	@Test
	void deleteTest() throws FilmNameNotFound {
		String name="Aman";
		doNothing().when(filmService).deleteFilm(name);
		filmController.deleteFilm(name);
		verify(filmService,times(1)).deleteFilm(name);
	}
	
	@Test
	void getFilmByName() throws FilmNameNotFound {
		String name="batman";
		//Film film = new Film(1,"Marvel",3000,(byte)5,null);
		Film film=new Film();
		film.setId(2);
		film.setName("batman");
		film.setRating((byte)4);
		film.setBoxOfficeCollection(4000);
		film.setDirector(null);
		ResponseEntity<Film> response=new ResponseEntity<>(film,HttpStatus.OK);
		when(filmService.getFilm(name)).thenReturn(film);
		assertEquals(response,filmController.getFilm(name));
	}
}
