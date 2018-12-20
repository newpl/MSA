package com.news.user.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("writer")
@Table(name = "npus02tb")
public class Writer extends User {

	@Size(max=50)
	@Column(name = "FULL_NM")
	private String fullNm;

	@Column(name = "USER_TYPE", length = 2)
	private String userType;

	@Column(name = "FNL_ANONYM_TYPE", length = 2)
	private String fnlAnonymType;	
	
	@Size(max=100)
	@Column(name = "PHOTO_PATH")
	private String photoPath;
}
