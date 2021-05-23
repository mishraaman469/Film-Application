package com.mt.film.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//@Configuration
@EnableWebSecurity
public class FilmSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailService;
	
		
		
		
		@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}


		@Bean
		public PasswordEncoder passwordEncoder() {
			return NoOpPasswordEncoder.getInstance();
		}

/*	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").hasRole("ADMIN")
		 .antMatchers("/user/**").hasAnyRole("user").antMatchers("/").permitAll().and().formLogin();
	}*/



	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").hasRole("ADMIN")
		 .antMatchers("/").permitAll().and().formLogin().and().csrf().disable();

	}*/
	/*	@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/dir/**","/director","/updateDirector","/film/**","/film").hasRole("ADMIN")
			 .antMatchers("/").permitAll().and().formLogin().and().csrf().disable();

		}*/
		
	/*	@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/**").hasRole("ADMIN")
			.antMatchers("/film/**","/dir/**","/director","/updateDirector","/displayDirector","/displayMovie").hasRole("USER")
			 .antMatchers("/").permitAll().and().formLogin().and().csrf().disable();

		}
		*/
		
		/*@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/dir/**","/displayDirector","/film/**","/displayMovie").hasRole("USER").antMatchers("/dir/**","/director","/updateDirector","/film/**","/film").hasRole("ADMIN")
			 .antMatchers("/").permitAll().and().formLogin().and().csrf().disable();

		}*/
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/dir/**","/displayDirector","/film/**","/displayMovie","/","/GetDirector.js","/GetMovie.js").hasAnyRole("USER","ADMIN").antMatchers("/**").hasRole("ADMIN")
			 .antMatchers("/").permitAll().and().formLogin().and().csrf().disable();

		}
		
}
