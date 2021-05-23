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

import com.mt.film.entity.Director;
import com.mt.film.exception.DirectorNameNotFound;
import com.mt.film.repository.DirectorRepository;

@SpringBootTest
class DirectorServiceImplTest {


	@InjectMocks
	DirectorServiceImpl directorServiceImpl;
	
	@Mock
	DirectorRepository directorRepository;
	
	
	@Test
	void test() { 
		List<Director> directors=new ArrayList<>();
		directors.add(new Director(1,"Aman",(byte)22,"male",(byte)4,null));
		directors.add(new Director(2,"Shubham",(byte)23,"male",(byte)4,null));
		directors.add(new Director(3,"Varshini",(byte)12,"female",(byte)4,null));
		directors.add(new Director(4,"Akhilesh",(byte)32,"male",(byte)4,null));
		
		when(directorRepository.findAll()).thenReturn(directors);
		assertEquals(directors,directorServiceImpl.getAllDirector());
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
		when(directorRepository.save(directors)).thenReturn(null);
		directorServiceImpl.saveDirector(directors);
		verify(directorRepository,times(1)).save(directors);
	}
	
	@Test
	void updateTest() throws DirectorNameNotFound {
		String name="Akhilesh";
		Director director=new Director(4,"Akhilesh",(byte)45,"male",(byte)5,null);
		Director directors=new Director(4,"Akhilesh",(byte)32,"male",(byte)4,null);
		when(directorRepository.findByName(name)).thenReturn(directors);
		when(directorRepository.save(directors)).thenReturn(director);
		assertEquals(director,directorServiceImpl.updateDirector(director));
	}
	
	@Test
	void getDirectorByName() throws DirectorNameNotFound {
		String name="Aman";
	//	Director director=new Director(1,"Aman",(byte)23,"male",(byte)5,null);
		Director director=new Director();
		director.setId(4);
		director.setName("Aman");
		director.setAge((byte)32);
		director.setGender("male");
		director.setAwardCount((byte)4);
		director.setFilm(null);
		when(directorRepository.findByName(name)).thenReturn(director);
		Director dir=directorServiceImpl.getDirector(name);
		assertEquals(director.getName(),dir.getName());
	}
	
	@Test
	void getDirectorByNameExceptionTest() {
		String name="Aman";
		assertThrows(DirectorNameNotFound.class,() -> directorServiceImpl.getDirector(name));
	}
	
	@Test
	void getDirectorUpdatexceptionTest() {
		Director director=new Director();
		director.setId(4);
		director.setName("Aman");
		director.setAge((byte)32);
		director.setGender("male");
		director.setAwardCount((byte)4);
		director.setFilm(null);
		assertThrows(DirectorNameNotFound.class,() -> directorServiceImpl.updateDirector(director));
	}
}
