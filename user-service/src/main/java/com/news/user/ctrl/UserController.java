package com.news.user.ctrl;

import java.util.List;

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
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<?> findUserList() {
		List<User> res = userService.findAll();
		return ResponseEntity.ok(res); 
	}
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		User res = userService.save(user);
		return ResponseEntity.ok(res); 
	}
}
