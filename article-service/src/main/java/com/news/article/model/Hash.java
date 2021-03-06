package com.news.article.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
 
@Data
@Entity
@Table(name = "npat31tb")
public class Hash extends BaseEntity implements Serializable {

	@EmbeddedId
	private HashPK pk;
	
	@Column(name = "HASH_TAG_NM", length = 4000)
	private String hashTagNm;
	
}
