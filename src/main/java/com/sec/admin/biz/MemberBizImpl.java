package com.sec.admin.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.admin.dao.MemberDao;
import com.sec.vo.MemberVO;

@Service
public class MemberBizImpl implements MemberBiz {
	@Autowired
	private MemberDao memberDao;

	@Override
	public MemberVO getMember(MemberVO member) {
		// TODO Auto-generated method stub
		
		return memberDao.getMember(member);
	}

}
