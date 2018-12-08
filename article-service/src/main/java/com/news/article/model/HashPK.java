package com.news.article.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
 
@Embeddable
@Data
public class HashPK implements Serializable {
	
	@Column(name = "ARTICLE_NO")
	private int aricleNo;

	@Column(name = "SNO")
	private int sno;
	
}
