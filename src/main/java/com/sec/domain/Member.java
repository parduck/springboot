package com.sec.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="boardList")
@Entity
public class Member {

	@Id 
	private String id;
	private String password;
	private String name; 
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
	
	@OneToMany(mappedBy="member",fetch=FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();
	
	
	
	//@OneToMany(mappedBy = "member", fetch=FetchType.EAGER, cascade=CascadeType.ALL) // Member 객체와 양방향 관계를 만들기위해 추가한다. (대상테이블)
	//private List<Board> boardList = new ArrayList<Board>() ;
	 	 
	
}
