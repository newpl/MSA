package com.news.article.restCtrl;

import com.news.article.model.Article;
import com.news.article.repo.ArticleRepository;
import com.news.article.svc.NewsSVC;
import com.news.common.base.BaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class SampleController {
	
//	@Autowired
//	ArticleServiceAPI articleServiceAPI;

	@Autowired
	NewsSVC newService;

	@Autowired
	private ArticleRepository articleRepository;

	//TEST 함수
	@GetMapping("/test1")
	public ResponseEntity test(){
		//		articleServiceAPI.test();
		
		return new ResponseEntity<>("정상", HttpStatus.ACCEPTED);
		
	}

	/**
	 * article 생성
	 *
	 * @param articleBody article 내용
	 * @return article 등록여부
	 */
	@PostMapping("/createArticle")
	public ResponseEntity createArticle(@RequestBody Article articleBody){

		System.out.println("called create Article"); //TODO log it out
		String response = newService.createArticle(articleBody);
		System.out.println(response);

		return new ResponseEntity(new BaseVO(), HttpStatus.OK);
	}

	/**
	 * articleNo 기반으로 기사 조회에 오기
	 *
	 * @param articleNo article ID정보
	 * @return 조회해온 Article 없을 시.. PRECONDITION FAILED. Because articleNo must be known.
	 */
	@GetMapping("/getArticle/{articleNo}")
	public ResponseEntity getArticle(@PathVariable("articleNo") Integer articleNo) {
		System.out.println("calling get Article"); //TODO log
		Article retrieved = new Article();
		try {
			retrieved = newService.getArticleByNO(articleNo);
		} catch (Exception e) {
			e.printStackTrace();
			//TODO what kind of exceptions are possible here?
		}
		//TODO check to see if article arctually exists... if not throw error
		if(retrieved.getArticleNo()!=articleNo) return new ResponseEntity(null,HttpStatus.PRECONDITION_FAILED);

		return new ResponseEntity(retrieved, HttpStatus.OK);
	}

	//TODO get article list
	//TODO delete article

}
