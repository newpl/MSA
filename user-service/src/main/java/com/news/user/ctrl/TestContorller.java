package com.news.user.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContorller {
	@GetMapping("/")
	public String index() {
		return "hello";
	}

}
