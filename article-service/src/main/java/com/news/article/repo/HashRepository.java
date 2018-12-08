package com.news.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.news.article.model.Hash;

public interface HashRepository extends JpaRepository<Hash,Integer>{

}
