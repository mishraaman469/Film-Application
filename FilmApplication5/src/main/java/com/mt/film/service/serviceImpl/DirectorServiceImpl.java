package com.mt.film.service.serviceImpl;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mt.film.entity.Director;
import com.mt.film.exception.DirectorNameNotFound;
import com.mt.film.repository.DirectorRepository;
import com.mt.film.service.DirectorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DirectorServiceImpl implements DirectorService  {

	@Autowired
	private DirectorRepository directorRepository;

	@Override
	public List<Director> getAllDirector() {
		log.info("In Director Service class");
		return this.directorRepository.findAll() ;
	}

	@Override
	public void saveDirector(Director director) {
		log.info("In Director Service class");
		Optional<Director> directors=Optional.ofNullable(directorRepository.findByName(director.getName()));
	//	Director directors=directorRepository.findByName(director.getName());
		System.out.println(directors);
		if(directors.isPresent()) {
			
		}else {
			 this.directorRepository.save(director);
		}
	
		
	}

	@Override
	public Director updateDirector(Director director) throws DirectorNameNotFound{
		/*Director direct=this.directorRepository.findById(id).orElseThrow(()-> new UserNameNotFound("Not Found"));
		if(director.getAge()==direct.getAge()|| director.getAwardCount()==direct.getAwardCount()) {
			throw new UserNameNotFound("Old data Repeated");
		}
		direct.setAge(director.getAge());
		direct.setAwardCount(director.getAwardCount());*/
		log.info("In Director Service class");
		Director directors=this.directorRepository.findByName(director.getName());
		if(directors==null) {
			throw new DirectorNameNotFound("Director with this particular name not found"+director.getName());
		}
		if(director.getAge()==directors.getAge()|| director.getAwardCount()==directors.getAwardCount()) {
			log.error("error occured");
			throw new DirectorNameNotFound("Old data Repeated for "+director.getName());
		}
		directors.setAge(director.getAge());
		directors.setAwardCount(director.getAwardCount());
		return this.directorRepository.save(directors);
	}

	@Override
	public Director getDirector(String name) throws DirectorNameNotFound {
		Optional<Director> directors=Optional.ofNullable(directorRepository.findByName(name));
		//Director director=this.directorRepository.findByName(name);
		log.info("In Director Service class");
		if(directors.isPresent()) {
			Director director=directors.get();
			return director;
		}else {
			log.error("error occured");
			throw new DirectorNameNotFound("Data with that name not found "+name);
		}
		 
	}

	

}
