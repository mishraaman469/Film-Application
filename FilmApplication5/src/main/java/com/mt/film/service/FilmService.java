package com.mt.film.service;

import java.util.List;

import com.mt.film.entity.Film;
import com.mt.film.exception.FilmNameNotFound;


public interface FilmService {

	List<Film> getAllFilm();

	void saveFilm(Film film);

	void deleteFilm(String name) throws FilmNameNotFound;

	Film getFilm(String name) throws FilmNameNotFound;

}
