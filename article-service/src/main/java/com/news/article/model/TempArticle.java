package com.news.article.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "npat02tb")
public class TempArticle extends BaseEntity implements Serializable {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEMP_ARTICLE_NO")
	private int tempArticleNo;
	
	@Column(name = "USER_NO")
	private int userNo;

	@Column(name = "TITLE", length = 120)
	private String title;
	
	@Column(name = "CONTENTS")
	private String contents;
	
	@Column(name = "CATEGORY_NO")
	private int categoryNo;	
	
	@Column(name = "DELETE_YN")
	private char deleteYn;

}
