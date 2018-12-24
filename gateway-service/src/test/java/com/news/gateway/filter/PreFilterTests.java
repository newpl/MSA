package com.news.gateway.filter;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.JsonObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PreFilterTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mock;

	@Before
	public void before() {
		mock = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void test() throws Exception {
		System.out.println("start");
		JsonObject content = new JsonObject();
		content.addProperty("contents", "<Script>테스트입니다.</scrIpt> <img src='null' >");
		mock.perform(MockMvcRequestBuilders.post("/api/article/test").contentType(MediaType.APPLICATION_JSON).content(content.toString()));
		System.out.println("end");
	}
}
