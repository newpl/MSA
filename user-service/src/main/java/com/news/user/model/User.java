package com.news.user.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(of="userNo")
@Builder @Entity
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Table(name = "npus01tb")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_NO")
	private Long userNo;
	
	@NotNull
	@Size(max=50)
	@Column(name = "USER_ID")
	private String userId;

	@NotNull
	@Size(max=50)
	@Column(name = "PASSWORD")
	private String password;

	@Size(max=50)
	@Column(name = "NICK_NM")
	private String nickNm;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name ="npus21tb",
			joinColumns = @JoinColumn(name = "USER_NO"),
			inverseJoinColumns = @JoinColumn(name= "ROLE_NO"))
	private List<Role> roles;
	
}
