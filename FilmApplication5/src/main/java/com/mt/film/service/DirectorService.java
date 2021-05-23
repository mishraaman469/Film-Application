package com.mt.film.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import com.mt.film.entity.Director;
import com.mt.film.entity.Film;
import com.mt.film.exception.DirectorNameNotFound;

public interface DirectorService {

	
	void saveDirector(Director director);

	Director updateDirector(Director director) throws DirectorNameNotFound;

	Director getDirector(String name) throws  DirectorNameNotFound;

	List<Director> getAllDirector();

}
