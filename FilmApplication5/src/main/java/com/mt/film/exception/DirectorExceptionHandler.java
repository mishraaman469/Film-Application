package com.mt.film.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mt.film.exception.entity.ApiError;

@RestControllerAdvice
public class DirectorExceptionHandler {

	@ExceptionHandler(DirectorNameNotFound.class)
	public ResponseEntity<ApiError> handleDirectorNameNotFoundException(DirectorNameNotFound director){
		ApiError error=new ApiError(404,director.getMessage(),new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleGlobalNotFoundException(Exception ex){
		ApiError error=new ApiError(404,ex.getMessage(),new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	
}
