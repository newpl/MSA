package com.news.article.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.news.article.model.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);
	List<Customer> findByIdBetween(Long id1, Long id2);
}
