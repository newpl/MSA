package com.news.article.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
   
@Data
@Entity
@Table(name = "npat32tb")
public class Category extends BaseEntity implements Serializable {

	@EmbeddedId
	private CategoryPK pk;
	
	@Column(name = "CATEGORY_STATUS")
	private int categoryStatus;

}
