package com.news.article.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
   
@Data
@Entity
@Table(name = "npat11tb")
public class ArticleScore extends BaseEntity implements Serializable {

	@EmbeddedId
	private ArticleReadPK pk;

	@Column(name = "SCORE")
	private int score;
	
	@Column(name = "DELETE_YN")
	private char deleteYn;

}
