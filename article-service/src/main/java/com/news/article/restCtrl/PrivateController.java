package com.news.article.restCtrl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.common.base.BaseVO;

@RestController
@RequestMapping("/private")
public class PrivateController {
	
	@PostMapping("/create")
	public ResponseEntity<BaseVO> create(){
		return new ResponseEntity<BaseVO>(new BaseVO(), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<BaseVO> update(){
		return new ResponseEntity<BaseVO>(new BaseVO(), HttpStatus.OK);
	}

	@PutMapping("/delete")
	public ResponseEntity<BaseVO> delete(){
		return new ResponseEntity<BaseVO>(new BaseVO(), HttpStatus.OK);
	}
}
