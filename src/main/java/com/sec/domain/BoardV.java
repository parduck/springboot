package com.sec.domain;

import java.util.Date;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;*/

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/* @Entity */
public class BoardV {

	/* @Id @GeneratedValue */
	private int seq;
	private String title;
	private String writer;
	private String content;
	/* @Temporal(value=TemporalType.TIMESTAMP) */
	private Date createDate = new Date();
	private int cnt =0;

	
}
