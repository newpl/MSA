package com.news.article.svc.impl;

import com.news.article.model.Article;
import com.news.article.repo.ArticleRepository;
import com.news.article.svc.NewsSVC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NewsSVCImpl implements NewsSVC{
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * Article 생성 API
     * The createArticle functions takes in an Article as a parameter and inserts the info into the database
     *  usually the information that comes from the web page will consist of the following:
     *  1. Article Category (yet defined)
     *  2. UserNumber (ID)
     *  3. Title
     *  4. Contents
     *
     *  The method will assume that the following exists.
     *
     * @param articleBody article that is received from page
     * @return TODO what is the return value for this service HTTP CODE?
     */
    @Override
    public String createArticle(Article articleBody) {

        //TODO figure out how to use article Status.
        articleBody.setArticleStatus(1);
        articleBody.setDeleteYn('N');

        try {
            articleRepository.save(articleBody);
        } catch (Exception e) {
            // In case if fails to insert to the DB.
            e.printStackTrace();
        }
        //TODO should there be a logic to check to see if everything is in order or is this okay?

        return null;
    }

    @Override
    public Article getArticleByNO(Integer articleNo) {
        System.out.println("#########"+ articleNo);
        Article retrievedArticle = articleRepository.findByarticleNo(articleNo);
        System.out.println(retrievedArticle.getArticleNo());

        return retrievedArticle;
    }

    @Override
    public String checkDeleteArticleByNO(Integer articleNo) {
        System.out.println("#########"+ articleNo);
        Article retrievedArticle = articleRepository.findByarticleNo(articleNo);

        return null;
    }

}
