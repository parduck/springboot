package com.sec.admin.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="boardList")
@Entity
public class Member {

	@Id 
	@Column(name="MEMBER_ID")
	private String id;
	private String password;
	private String name; 
	private String role;
	
	
	
	@OneToMany(mappedBy = "member", fetch=FetchType.EAGER, cascade=CascadeType.ALL) // Member 객체와 양방향 관계를 만들기위해 추가한다. (대상테이블)
	private List<Board> boardList = new ArrayList<Board>() ;
	 	 
	
}
