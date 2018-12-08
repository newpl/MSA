package com.news.article.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
  
@Data
@Entity
@Table(name = "npat01tb")
public class Article extends BaseEntity implements Serializable {

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ARTICLE_NO")
	private int aricleNo;
	
	@Column(name = "USER_NO")
	private int userNo;
	
	@Column(name = "ARTICLE_STATUS")
	private int articleStatus;
	
	@Column(name = "TITLE", length = 120)
	private String title;
	
	@Column(name = "CONTENTS")
	private String contents;
	
	@Column(name = "CATEGORY_NO")
	private int categoryNo;	
	
	@Column(name = "DELETE_YN")
	private char deleteYn;

}
