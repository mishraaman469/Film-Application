package com.mt.film.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mt.film.entity.Film;
import com.mt.film.exception.FilmNameNotFound;
import com.mt.film.repository.FilmRepository;

@SpringBootTest
class FilmServiceImplTest {

	@InjectMocks
	FilmServiceImpl filmServiceImpl;
	
	@Mock
	FilmRepository filmRepository;
	
	
	@Test
	void test() {
		List<Film> film=new ArrayList<>();
		film.add(new Film(1,"Avenger",3000,(byte)5,null));
		film.add(new Film(2,"batman",4000,(byte)4,null));
	
		when(filmRepository.findAll()).thenReturn(film);
		assertEquals(film,filmServiceImpl.getAllFilm());
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
		when(filmRepository.save(film)).thenReturn(null);
		filmServiceImpl.saveFilm(film);
		verify(filmRepository).save(film);
	}

	
	@Test
	void deleteTest() throws FilmNameNotFound {
		String name="marvel";
		Film film=new Film(2,"marvel",4000,(byte)4,null);
		when(filmRepository.findByName(name)).thenReturn(film);
		filmServiceImpl.deleteFilm(name);
		verify(filmRepository,times(1)).deleteByName(name);
	
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
		when(filmRepository.findByName(name)).thenReturn(film);
		Film fil=filmServiceImpl.getFilm(name);
		assertEquals(film.getName(),fil.getName());
	}
	
	@Test
	void exceptionGetFilmByNameTest() {
		String name="";
		//doNothing().when(filmService).saveFilm(film);
		assertThrows(FilmNameNotFound.class, ()->filmServiceImpl.getFilm(name));
	}
	
	@Test
	void exceptionPostTest() {
		String name="Aman";
		assertThrows(FilmNameNotFound.class, ()->filmServiceImpl.nameFilm(name));
	}
	
	
	
	
}
