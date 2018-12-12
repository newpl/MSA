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

import com.news.article.repo.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CategoryTests {

	@Autowired
	private CategoryRepository repository;

	@Test
	public void test() {
		// given
		Category category = new Category();
		CategoryPK pk = new CategoryPK();
		pk.setCategoryNm("사회");
		pk.setCategoryNo(1);
		category.setPk(pk);
		category.setCategoryStatus(0);

		repository.save(category);

		// when
		Optional<Category> findCategory = repository.findById(pk);

		// then
		assertThat(findCategory.get().getPk().getCategoryNm()).isEqualTo("사회");
		assertThat(findCategory.get().getPk().getCategoryNo()).isEqualTo(1);
		assertThat(findCategory.get().getCategoryStatus()).isEqualTo(0);
	
	}

}
