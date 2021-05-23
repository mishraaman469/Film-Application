package com.mt.film.exception;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mt.film.exception.entity.ApiError;

@SpringBootTest
class DirectorExceptionHandlerTest {

	@Autowired
	DirectorExceptionHandler directorExceptionHandler;
	
	@Test
	void test() {
		DirectorNameNotFound d=new DirectorNameNotFound("Not found");
		ApiError error=new ApiError(404,d.getMessage(),new Date());
		ResponseEntity<ApiError> response = new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
		//when(directorExceptionHandler.handleDirectorNameNotFoundException(d)).thenReturn(response);
		//assertEquals(response,directorExceptionHandler.handleDirectorNameNotFoundException(d));
		assertNotNull(directorExceptionHandler.handleDirectorNameNotFoundException(d));
	}
	
	@Test
	void globalException() {
		Exception e=new Exception();
		ApiError error=new ApiError(404,e.getMessage(),new Date());
		ResponseEntity<ApiError> response = new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
		//when(directorExceptionHandler.handleDirectorNameNotFoundException(d)).thenReturn(response);
		//assertEquals(response,directorExceptionHandler.handleDirectorNameNotFoundException(d));
		assertNotNull(directorExceptionHandler.handleGlobalNotFoundException(e));
	}

}
