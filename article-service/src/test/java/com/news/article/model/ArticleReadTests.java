package com.news.article.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.news.article.repo.ArticleReadRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ArticleReadTests {

	@Autowired
	private ArticleReadRepository repository;

	@Test
	public void test() {
		// given
		ArticleRead articleRead = new ArticleRead();
		ArticleReadPK pk = new ArticleReadPK();
		pk.setAricleNo(1);
		pk.setUserNo(1);
		articleRead.setPk(pk);

		repository.save(articleRead);

		// when
		Optional<ArticleRead> findArticle = repository.findById(pk);

		// then
		assertThat(findArticle.get().getPk().getAricleNo()).isEqualTo(1);
		assertThat(findArticle.get().getPk().getUserNo()).isEqualTo(1);
	
	}

}
