package com.news.article.restCtrl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SampleController {
	
//	@Autowired
//	ArticleServiceAPI articleServiceAPI;
	
	@GetMapping("/test1")
	public ResponseEntity test(){
//		articleServiceAPI.test();
		
		return new ResponseEntity<>("정상", HttpStatus.ACCEPTED);
		
	}
}
