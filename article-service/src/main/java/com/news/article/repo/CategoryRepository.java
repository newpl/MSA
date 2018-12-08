package com.news.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.article.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
