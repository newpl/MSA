package com.news.article.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
 
@Embeddable
@Data
public class CategoryPK implements Serializable {
	
	@Column(name = "CATEGORY_NO")
	private int categoryNo;

	@Column(name = "CATEGORY_NM")
	private String categoryNm;
	
}
