package com.news.user.ctrl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.user.common.TestDescription;
import com.news.user.model.Role;
import com.news.user.model.User;
import com.news.user.repo.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	MockMvc mockMvc;

	@Autowired
	UserRepository userRepository;
	
	@Test
	@TestDescription("200 - 정상적으로 유저 생성했을 때")
	public void createUser() throws Exception {
		//Given
		long id = 1;
		String userId = "user";
		String password = "1234";
		String nickNm = "Nick";
		List<Role> roles = Arrays.asList(new Role(id, "TEST_ROLE"));
		
		//When
		User user = User.builder()
				.userNo(id)
				.userId("test1")
				.password("test1")
				.nickNm("테스트")
				.roles(roles)
				.build();
		
		//Then
		mockMvc.perform(post("/user")
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(user)))
						.andDo(print())
						.andExpect(status().isOk());
	}
	
	@Test
	@TestDescription("400 - 잘못된 입력 값 있을 때")
	public void createUser_BadRequestWrongInput() throws Exception {
	}

	@Test
	@TestDescription("400 - 필수 입력에 널 값 있을 때")
	public void createUser_BadRequestNullInput() throws Exception {
	}
	
	@Test
	@TestDescription("404 - 응답페이지 찾을 수 없을 때")
	public void createUser_NotFound() throws Exception {
	}

	@Test
	@TestDescription("401 - 권한 없을 때 ")
	public void createUser_Unauthority() throws Exception {
	}

	@Test
	@TestDescription("409 - 이미 있는 유저일 때 ")
	public void createUser_Conflict() throws Exception {
	}

	@Test
	@TestDescription("500 - 기타 서버 오류들 있을 때")
	public void createUser_InternalError() throws Exception {
	}

}
