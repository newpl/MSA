package com.news.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.article.model.Article;
   
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
