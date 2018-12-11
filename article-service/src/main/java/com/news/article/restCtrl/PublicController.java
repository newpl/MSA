package com.news.article.restCtrl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.common.base.BaseVO;

@RestController
@RequestMapping("/public")
public class PublicController {
	
	@GetMapping("/sel")
	public ResponseEntity<BaseVO> sel(){
		return new ResponseEntity<BaseVO>(new BaseVO(), HttpStatus.OK);
	}
}
