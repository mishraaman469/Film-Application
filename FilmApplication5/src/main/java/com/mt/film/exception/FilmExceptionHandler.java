package com.mt.film.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mt.film.exception.entity.ApiError;

@RestControllerAdvice
public class FilmExceptionHandler {

	@ExceptionHandler(FilmNameNotFound.class)
	public ResponseEntity<ApiError> handleFilmNameNotFoundException(FilmNameNotFound film){
		ApiError error=new ApiError(404,film.getMessage(),new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleNotFoundException(Exception ex){
		ApiError error=new ApiError(404,"Path variable should not be empty",new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	
}
