package com.mt.film.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Film {	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private  String name;	
		private double boxOfficeCollection;
		private byte rating;
		@ManyToMany
		@JsonIgnoreProperties("film")
		List<Director> director;	
}
