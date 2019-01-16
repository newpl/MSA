package com.news.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.article.model.ArticleRead;
import com.news.article.model.ArticleReadPK;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleReadRepository extends JpaRepository<ArticleRead, ArticleReadPK>{

}
