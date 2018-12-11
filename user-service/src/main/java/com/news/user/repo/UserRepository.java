package com.news.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.user.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserId(String userId);
}
