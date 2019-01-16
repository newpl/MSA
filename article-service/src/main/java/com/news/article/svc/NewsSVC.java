package com.news.article.svc;

import com.news.article.model.Article;

public interface NewsSVC {
    /**
     * article 생성 API
     * @param articleBody 기상정보
     * @return String 정보 생성 여부
     */
    String createArticle(Article articleBody);

    /**
     * article 조회 by articleNo
     * @param articleNo 조회할 기사의 ID
     * @return 기사내용?
     */
    Article getArticleByNO(Integer articleNo);

    /**
     * article 삭제여부 Update
     * @param articleNo 삭제할 기사의 ID
     * @return 삭제여부
     */
    String checkDeleteArticleByNO(Integer articleNo);
}
