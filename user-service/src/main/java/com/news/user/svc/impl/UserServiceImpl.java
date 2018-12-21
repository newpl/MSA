package com.news.user.svc.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.user.ctrl.UserController;
import com.news.user.model.User;
import com.news.user.repo.UserRepository;
import com.news.user.svc.UserService;

@Service
public class UserServiceImpl implements UserService{

	static private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;

//	@Autowired
//	PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> findAll() {
		LOGGER.debug("findAll");
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
