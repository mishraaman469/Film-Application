package com.mt.film.entity;

import java.util.Comparator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Director implements Comparator<Director>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private byte age;
	private String gender;
	private byte awardCount;
	@ManyToMany(mappedBy = "director")
	private List<Film> film;
	@Override
	public int compare(Director o1, Director o2) {
		return o1.getName().compareTo(o2.getName());
	}


	
	
	
}
