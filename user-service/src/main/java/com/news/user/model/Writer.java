package com.news.user.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("writer")
@Table(name = "npus02tb")
public class Writer extends User {
	@Column(name = "FULL_NM", length = 50)
	private String fullNm;
	@Column(name = "USER_TYPE", length = 2)
	private String userType;
	@Column(name = "FNL_ANONYM_TYPE", length = 2)
	private String fnlAnonymType;
	@Column(name = "PHOTO_PATH", length = 100)
	private String photoPath;
}
