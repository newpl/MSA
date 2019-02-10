package com.news.article.svc.impl;

import com.news.article.model.Article;
import com.news.article.model.TempArticle;
import com.news.article.repo.ArticleRepository;
import com.news.article.repo.TempArticleRepository;
import com.news.article.svc.NewsSVC;
import com.news.article.svc.TempArticleSVC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TempArticleSVCImpl implements TempArticleSVC {
    //로깅
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TempArticleRepository tempArticleRepository;

    /**
     * 임시 Article 생성
     *
     * @param articleBody 임시 Article
     * @return
     */
    @Override
    public String createTempArticle(TempArticle articleBody) {
        //TODO figure out how to use article Status.
        articleBody.setDeleteYn('N');

        try {
            tempArticleRepository.save(articleBody);
        } catch (Exception e) {
            // In case if fails to insert to the DB.
            e.printStackTrace();
        }
        //TODO should there be a logic to check to see if everything is in order or is this okay?

        return null;
    }

    /**
     * Temporary Article 불러오기(조회)
     * @param articleNo 조회용 ArticleNo 값
     * @return TempArticle 객체
     */
    @Override
    public TempArticle getTempArticleByNO(Integer articleNo) {
        log.debug("Getting temporary article["+articleNo+"]");
        TempArticle retrievedTempArticle = tempArticleRepository.findBytempArticleNo(articleNo);
        log.debug("Temporary Article Retrieved.");

        return retrievedTempArticle;
    }

    @Override
    public String DeleteTempArticleByNO(Integer articleNo) {
        return null;
    }
}
