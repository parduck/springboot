package com.sec.admin.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.admin.biz.MemberBiz;
import com.sec.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	//껍데기 impl을 먼저 만들고 alt+ shift+T

	@Autowired
	private MemberBiz memberBiz;
	
	@Override
	public MemberVO getMember(MemberVO member) {
		return memberBiz.getMember(member);
		
	}
}
