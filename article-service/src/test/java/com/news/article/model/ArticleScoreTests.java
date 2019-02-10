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

import com.news.article.repo.ArticleScoreRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ArticleScoreTests {

	@Autowired
	private ArticleScoreRepository repository;

	@Test
	public void test() {
		// given
		ArticleScore articleScore= new ArticleScore();
		ArticleReadPK pk = new ArticleReadPK();
		pk.setAricleNo(1);
		pk.setUserNo(1);
		articleScore.setPk(pk);
		articleScore.setDeleteYn('N');
		articleScore.setScore(100);
		
		repository.save(articleScore);

		// when
		Optional<ArticleScore> findArticle = repository.findById(pk);

		// then
		assertThat(findArticle.get().getPk().getAricleNo()).isEqualTo(1);
		assertThat(findArticle.get().getPk().getUserNo()).isEqualTo(1);
		assertThat(findArticle.get().getDeleteYn()).isEqualTo('N');
		assertThat(findArticle.get().getScore()).isEqualTo(100);
	
	}

}
