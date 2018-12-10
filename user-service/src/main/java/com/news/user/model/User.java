package com.news.user.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Table(name = "npus01tb")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_NO")
	private Long userNo;
	
	@NotNull
	@Column(name = "USER_ID", length = 50)
	private String userId;
	@NotNull
	@Column(name = "PASSWORD", length = 50)
	private String password;

	@Column(name = "NICK_NM", length = 50)
	private String nickNm;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Role> roles;
	
}
