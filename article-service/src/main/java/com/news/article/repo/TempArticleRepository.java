/*
  @Id newpl
 */
package com.news.article.repo;

import com.news.article.model.TempArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TempArticleRepository 는 Article, 즉 임시 저장 기사용 Repository 입니다.*
 */
@Repository
public interface TempArticleRepository extends JpaRepository<TempArticle, Integer> {

    /**
     * findBytempArticleNo function is used to query for a temporary article using tamparticleNo as the parameter.
     * @param tempArticleNo temporary article ID
     * @return Article Objects that matches the articleNo
     */
    TempArticle findBytempArticleNo(Integer tempArticleNo);
}
