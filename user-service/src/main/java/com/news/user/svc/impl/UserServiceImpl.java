package com.news.user.svc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.user.model.User;
import com.news.user.repo.UserRepository;
import com.news.user.svc.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

//	@Autowired
//	PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		if(userRepository.existsById(id)) userRepository.deleteById(id);
	}

}
