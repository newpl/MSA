package com.news.user.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.user.model.User;
import com.news.user.svc.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	static private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<?> findUserList() {
		List<User> res = userService.findAll();
		return ResponseEntity.ok(res); 
	}
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		
		LOGGER.debug("UserController : " + user);
		User res = userService.save(user);
		return ResponseEntity.ok(res); 
	}
}