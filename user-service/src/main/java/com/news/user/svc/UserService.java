package com.news.user.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.user.model.User;
import com.news.user.repo.UserRepository;

@Service
public class UserService { 
	@Autowired
	UserRepository userRepository;

//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<User> findAll() {		
		return userRepository.findAll();
	}

	public User save(User user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public void delete(Long id) {
		if(userRepository.existsById(id)) userRepository.deleteById(id);
	}
}
