package com.news.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.article.model.ArticleRead;

public interface ArticleReadRepository extends JpaRepository<ArticleRead, Integer>{

}
