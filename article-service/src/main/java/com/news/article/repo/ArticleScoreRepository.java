package com.news.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.article.model.ArticleReadPK;
import com.news.article.model.ArticleScore;
   
public interface ArticleScoreRepository extends JpaRepository<ArticleScore, ArticleReadPK>{

}
