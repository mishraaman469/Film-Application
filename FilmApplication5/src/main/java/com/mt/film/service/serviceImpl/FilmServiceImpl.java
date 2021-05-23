package com.mt.film.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mt.film.entity.Film;
import com.mt.film.exception.FilmNameNotFound;
import com.mt.film.repository.FilmRepository;
import com.mt.film.service.FilmService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	@Override
	public List<Film> getAllFilm() {
		log.info("in film service class");
		return this.filmRepository.findAll(); 
	}

	@Override
	public void saveFilm(Film film) {
		//Film films=filmRepository.findByName(film.getName());
		Optional<Film> films=Optional.ofNullable(filmRepository.findByName(film.getName()));
		log.info("in film service class");
		if(films.isPresent()) {
			
		}else {
			 this.filmRepository.save(film);
		}
	
		
	}
		
	

	public void nameFilm(String name) throws FilmNameNotFound {
		
		Optional<Film> film=Optional.ofNullable(filmRepository.findByName(name));
		log.info("in film service class");
		if(film.isEmpty()) {
			log.error("error encountered");
			throw new FilmNameNotFound("Film with this particular name not found "+name);
		}
		
		}


	@Override
	public void deleteFilm(String name) throws FilmNameNotFound {
	nameFilm(name);
	log.info("in service class");
	 this.filmRepository.deleteByName(name);
		
	}

	@Override
	public Film getFilm(String name) throws FilmNameNotFound {
		log.info("in film service class");
		Optional<Film> film=Optional.ofNullable(filmRepository.findByName(name));
		if(film.isEmpty()) {
			throw new FilmNameNotFound("Film with this particular name not found "+name);
		}
		Film films=film.get();
		return films;
	}

}
