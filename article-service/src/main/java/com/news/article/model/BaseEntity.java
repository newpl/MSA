package com.news.article.model;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
  
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATETIME")
	@CreatedDate
	private Date createdDatetime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATETIME")
	@LastModifiedDate
	private Date updatedDatetime;

	@Column(name = "CREATED_USER_ID")
	private int createdUserId;

	@Column(name = "UPDATED_USER_ID")
	private int updatedUserId;
	
}
