package com.news.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.article.model.ArticleRead;
import com.news.article.model.ArticleReadPK;
   
public interface ArticleReadRepository extends JpaRepository<ArticleRead, ArticleReadPK>{

}
