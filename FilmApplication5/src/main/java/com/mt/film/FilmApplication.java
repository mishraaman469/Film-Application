package com.mt.film;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mt.film.repository.UserRepository;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class FilmApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmApplication.class, args);
	}

	@Bean
	public Docket getDocketApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.mt.film"))
				.build().apiInfo(apiDetail());
	}

	private ApiInfo apiDetail() {
		return new ApiInfo("Film Application", "All Film Detail", "1.0", "Free to use",
				new springfox.documentation.service.Contact("Aman Mishra", "google.com", "mishraaman469@gmail.com"),
				"Api License", "google.com", Collections.emptyList());
	}

}
