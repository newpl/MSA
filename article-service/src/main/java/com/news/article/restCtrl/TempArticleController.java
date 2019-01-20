package com.news.article.restCtrl;

import com.news.article.model.TempArticle;
import com.news.article.svc.TempArticleSVC;
import com.news.common.base.BaseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Temporary Article Controller Class
 */
@RestController
@RequestMapping("/temp")
public class TempArticleController {

    // 로깅관련
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TempArticleSVC tempArticleService;

//    @Autowired
//    private TempArticleRepository tempArticleRepository;

    /**
     * temporary article 생성
     *
     * @param articleBody temporary article 내용
     * @return article 생성여부 (DB 기재 여부)
     */
    @PostMapping("/createTempArticle")
    public ResponseEntity createTempArticle(@RequestBody TempArticle articleBody){

        logger.debug("---creating temporary article from userID:"+articleBody.getUserNo()+" ---");
        String response = tempArticleService.createTempArticle(articleBody);

        return new ResponseEntity(new BaseVO(), HttpStatus.OK);
    }

    /**
     * articleNo 기반으로 임시 기사 조회에 오기
     *
     * @param tempArticleNo temporary article ID정보
     * @return 조회해온 temporary Article 없을 시.. PRECONDITION FAILED. Because articleNo must be known.
     */
    @GetMapping("/getTempArticle/{tempArticleNo}")
    public ResponseEntity getTempArticle(@PathVariable("tempArticleNo") Integer tempArticleNo) {
        TempArticle retrieved = new TempArticle();
        try {
            logger.debug("--- retrieving article with article Number :" + tempArticleNo + " ---");
            retrieved = tempArticleService.getTempArticleByNO(tempArticleNo);

            if (retrieved == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException n) {
            logger.error("Temporary article with id "+
                    tempArticleNo+"does not exists");
            n.printStackTrace();
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            //TODO what kind of exceptions are possible here?
        }

        return new ResponseEntity(retrieved, HttpStatus.OK);
    }

    //TODO delete temporary article
    @GetMapping("/deleteTempArticle/{tempArticleNo}")
    public ResponseEntity deleteTempArticle(@PathVariable("tempArticleNo") Integer tempArticleNo) {


        //TODO figure out what to return.
        return new ResponseEntity(new BaseVO(), HttpStatus.OK);
    }
}
