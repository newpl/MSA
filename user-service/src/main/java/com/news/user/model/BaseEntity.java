package com.news.user.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	@Column(name = "DELETE_YN", length = 1)
	private String deleteYn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATETIME")
	@CreatedDate
	private Date createdDatetime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATETIME")
	@LastModifiedDate
	private Date updatedDatetime;

	@Size(max=120)
	@Column(name = "CREATED_SOURCE_ID")
	private String createdSourceId;

	@Size(max=120)
	@Column(name = "UPDATED_SOURCE_ID")
	private String updatedSourceId;

}