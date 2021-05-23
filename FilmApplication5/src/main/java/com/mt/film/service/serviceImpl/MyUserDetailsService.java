package com.mt.film.service.serviceImpl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mt.film.entity.MyUserDetails;
import com.mt.film.entity.User;
import com.mt.film.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=userRepository.findByUserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found"+username));
		return user.map(MyUserDetails::new).get();
	}

}
