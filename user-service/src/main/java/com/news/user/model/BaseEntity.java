package com.news.user.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
	private long createdUserId;

	@Column(name = "UPDATED_USER_ID")
	private long updatedUserId;
	
}