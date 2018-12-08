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
	private int aricleNo;
	
	private int userNo;
	
	private int articleStatus;
	
	@Column(length = 120)
	private String title;
	
	private String contents;
	
	private int categoryNo;	
	
	private char deleteYn;

}
