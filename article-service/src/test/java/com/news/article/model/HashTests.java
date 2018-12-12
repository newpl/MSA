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

import com.news.article.repo.HashRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class HashTests {

	@Autowired
	private HashRepository repository;

	@Test
	public void test() {
		// given
		Hash hash = new Hash();
		HashPK pk = new HashPK();
		pk.setAricleNo(1);
		pk.setSno(1);
		hash.setPk(pk);
		hash.setHashTagNm("#테스트");
		repository.save(hash);

		// when
		Optional<Hash> findHash = repository.findById(pk);

		// then
		assertThat(findHash.get().getPk().getAricleNo()).isEqualTo(1);
		assertThat(findHash.get().getPk().getSno()).isEqualTo(1);
		assertThat(findHash.get().getHashTagNm()).isEqualTo("#테스트");
	
	}

}
