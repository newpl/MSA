/*
  @Id newpl
 */
package com.news.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.news.article.model.Article;
import org.springframework.stereotype.Repository;

/**
 * ArticleRepository 는 Article, 즉 기사용 Repository 입니다.*
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    /**
     * findByarticleNo function is used to query for an article using articleNo as the parameter.
     * @param articleNo article ID
     * @return Article Objects that matches the articleNo
     */
    Article findByarticleNo(Integer articleNo);
}
