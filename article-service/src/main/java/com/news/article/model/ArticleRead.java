package com.news.article.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
   
@Data
@Entity
@Table(name = "npat12tb")
public class ArticleRead extends BaseEntity implements Serializable {
	
	@EmbeddedId
	private ArticleReadPK pk;
}
