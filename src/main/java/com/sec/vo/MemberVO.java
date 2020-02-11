package com.sec.vo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MemberVO {
	private String id;
	private String password;
	private String name; 
	private String role;
	private String enabled;
}
