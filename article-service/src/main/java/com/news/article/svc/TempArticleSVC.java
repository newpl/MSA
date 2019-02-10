package com.news.article.svc;

import com.news.article.model.TempArticle;

/**
 *  Temporary Article Service
 */
public interface TempArticleSVC {

    String createTempArticle(TempArticle articleBody);

    TempArticle getTempArticleByNO(Integer articleNo);

    String DeleteTempArticleByNO(Integer articleNo);
}
