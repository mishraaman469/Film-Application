package com.mt.film.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mt.film.entity.Film;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository<Film, Integer> {

	//@Query("delete from Film b where b.name=:name")
	void deleteByName(String name);

	Film findByName(String name);

	@Query("select b from Film b where b.name=:name")
	Film findAllByName(@Param("name") String name);

	
		

}
