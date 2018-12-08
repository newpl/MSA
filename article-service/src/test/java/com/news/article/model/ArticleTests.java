package com.news.article.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.news.article.repo.ArticleRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ArticleTests {

	@Autowired
	private ArticleRepository repository;

	@Test
	public void test() {
		// given
		Article article = new Article();
		article.setArticleStatus(0);
		article.setContents("내용 test");
		article.setDeleteYn('N');
		article.setTitle("제목 test");
		article.setUserNo(1);
		
		repository.save(article);

		// when
		List<Article> articleList = repository.findAll();

		// then
		Article articles = articleList.get(0);
		assertThat(articles.getArticleStatus()).isEqualTo(0);
		assertThat(articles.getContents()).isEqualTo("내용 test");
		assertThat(articles.getDeleteYn()).isEqualTo('N');
		assertThat(articles.getTitle()).isEqualTo("제목 test");
		assertThat(articles.getUserNo()).isEqualTo(1);

	}
	
}
