package com.news.article.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "npat32b")
public class Category extends BaseEntity implements Serializable {

	@Id
	private int categoryNo;

	@Id
	@Column(length = 100)
	private String categoryNm;
	
	private int categoryStatus;

}
