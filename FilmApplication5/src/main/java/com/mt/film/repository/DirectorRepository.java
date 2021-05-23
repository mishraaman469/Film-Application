package com.mt.film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.mt.film.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {

	Director findByName(String name);

}
