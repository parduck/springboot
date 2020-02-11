package com.sec.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "member")
@Entity
public class Board {

	@Id
	@GeneratedValue
	private long seq;
	private String title;

	// @Column(name="id")
	// private String id;
	//private String writer;

	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate = new Date();
	@Column(updatable = false)
	private long cnt = 0L;

	@ManyToOne
	@JoinColumn(name = "WRITER", nullable = false, updatable = false) // -->outer join을 inner join으로 바꿀
	private Member member;

	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}

}
