package com.sec.admin.dao;

import org.springframework.stereotype.Component;

import com.sec.vo.MemberVO;


public interface MemberDao {

	MemberVO getMember(MemberVO member);

}