package com.news.auth;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> auths = new ArrayList<>();
		auths.add(new SimpleGrantedAuthority("USER"));
		return new org.springframework.security.core.userdetails.User("dongha", passwordEncoder.encode("1234"), auths);
	}
}
