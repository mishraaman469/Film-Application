package com.mt.film.webController;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class DirectorWebControllerTest {

	@Autowired
	DirectorWebController directorWebController;
	
	@Test
	void test() {
		//when(directorWebController.postDirector()).thenReturn("formDirector");
		assertEquals("formDirector", directorWebController.postDirector());
	}
	
	@Test
	void postFilmtest() {
		//when(directorWebController.postDirector()).thenReturn("formDirector");
		assertEquals("form", directorWebController.postFilm());
	}
	
	@Test
	void indexPageTest() {
		//when(directorWebController.postDirector()).thenReturn("formDirector");
		assertEquals("index", directorWebController.indexPage());
	}
	
	@Test
	void displayDirectorTest() {
		//when(directorWebController.postDirector()).thenReturn("formDirector");
		assertEquals("GetFormDirector", directorWebController.displayDirector());
	}
	
	@Test
	void deleteMoovieTest() {
		//when(directorWebController.postDirector()).thenReturn("formDirector");
		assertEquals("deleteMovie", directorWebController.deleteMoovie());
	}
	
	@Test
	void displayMovieTest() {
		//when(directorWebController.postDirector()).thenReturn("formDirector");
		assertEquals("GetFormMovie", directorWebController.displayMovie());
	}
	
	@Test
	void updateTest() {
		//when(directorWebController.postDirector()).thenReturn("formDirector");
		assertEquals("updateDirector", directorWebController.update());
	}
	
	
	

}
