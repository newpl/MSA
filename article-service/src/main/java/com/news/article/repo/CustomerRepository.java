package com.news.article.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.article.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);
	List<Customer> findByIdBetween(Long id1, Long id2);

	
}