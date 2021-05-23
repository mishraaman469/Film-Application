package com.mt.film.exception.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ApiError {
	
	private int number;
	
	private String message;
	
	private Date date;
	
}
