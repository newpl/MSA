package com.news.user.svc;

import java.util.List;


import com.news.user.model.User;

public interface UserService { 

	public List<User> findAll();

	public User save(User user);

	public void delete(Long id);
}
