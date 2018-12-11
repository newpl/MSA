package com.news.user.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.news.user.model.User;
import com.news.user.svc.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	public ResponseEntity<?> findUserList() {
		List<User> res = userService.findAll();
		
		return ResponseEntity.ok(res); 
	}
	
}
