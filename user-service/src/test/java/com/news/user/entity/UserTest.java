package com.news.user.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.news.user.model.Role;
import com.news.user.model.User;

public class UserTest {
	
	@Test
	public void builder() {
		//Given
		long id = 1;
		String userId = "user";
		String password = "1234";
		String nickNm = "Nick";
		List<Role> roles = Arrays.asList(new Role(id, "TEST_ROLE"));

		//When
		
		User testUser = User.builder()
							.userNo(id)
							.userId("")
							.password("")
							.nickNm("")
							.roles(null)
							.build();
		//Then
		assertThat(testUser.getUserNo()).isEqualTo(id);
		assertThat(testUser.getUserId()).isEqualTo(userId);
		assertThat(testUser.getPassword()).isEqualTo(password);
		assertThat(testUser.getNickNm()).isEqualTo(nickNm);
		assertThat(testUser.getRoles()).isEqualTo(roles);
		
	}
	
	@Test 
	public void javaBean() {
		long userNo = 1;
		User testUser = new User();
		testUser.setUserNo(userNo);
		
		assertThat(testUser.getUserNo()).isEqualTo(userNo);
	}
}
