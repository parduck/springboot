package com.sec.vo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BoardVO {
	private long seq;
	private String title;

	private String writer;
	
	private String content;
	private Date createDate;
	private long cnt;
	
	MemberVO member;

}
