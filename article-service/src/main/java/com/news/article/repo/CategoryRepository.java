package com.news.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.article.model.Category;
import com.news.article.model.CategoryPK;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, CategoryPK>{

}
 