package com.news.article.model;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
  
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdDatetime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updatedDatetime;

	private int createdUserId;

	private int updatedUserId;
	
}
