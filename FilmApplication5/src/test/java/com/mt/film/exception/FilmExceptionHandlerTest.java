package com.mt.film.exception;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mt.film.exception.entity.ApiError;

@SpringBootTest
class FilmExceptionHandlerTest {

		@Autowired
		FilmExceptionHandler filmExceptionHandler; 
		
		
		@Test
		void test() {
			FilmNameNotFound d=new FilmNameNotFound("Not found");
			ApiError error=new ApiError(404,d.getMessage(),new Date());
			ResponseEntity<ApiError> response = new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
			//when(directorExceptionHandler.handleDirectorNameNotFoundException(d)).thenReturn(response);
			//assertEquals(response,directorExceptionHandler.handleDirectorNameNotFoundException(d));
			//assertNotNull(filmExceptionHandler.handleFilmNameNotFoundException(d));
			assertNotNull( filmExceptionHandler.handleFilmNameNotFoundException(d));
		}
		
		@Test
		void globalException() {
			Exception e=new Exception();
			ApiError error=new ApiError(404,e.getMessage(),new Date());
			ResponseEntity<ApiError> response = new ResponseEntity<ApiError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
			//when(directorExceptionHandler.handleDirectorNameNotFoundException(d)).thenReturn(response);
			//assertEquals(response,directorExceptionHandler.handleDirectorNameNotFoundException(d));
			assertNotNull(filmExceptionHandler.handleNotFoundException(e));
					
		}
}
