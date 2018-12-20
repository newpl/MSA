package com.news.user;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.news.user.model.User;
import com.news.user.repo.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTest {

	@Autowired
	UserRepository repo;
	

	@Test
	public void createUserTest() {
//		repo.save(new User("user1","user1",Arrays.asList(new Role("USER"))));
	}

	@Test
	public void createReporterTest() {
//		repo.save(new Writer("hey","hey",Arrays.asList(new Role("USER")),"타입"));
	}

	
	@Test
	public void createSubsTest() {
		Optional<User> user = repo.findById((long) 1);
//		Optional<Reporter> reporter = repo.findById((long)2);
		
		System.out.println(user.toString());
//		subs.save(new Subs());
	}
}