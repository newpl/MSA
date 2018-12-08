package com.news.article.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "npat11tb")
public class ArticleScore extends BaseEntity implements Serializable {

	@Id
	private int aricleNo;

	@Id
	private int userNo;

	private int score;
	
	private char deleteYn;

}
