package com.sec.admin.dao;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sec.domain.Board;
import com.sec.domain.Member;
import com.sec.repo.MemberRepository;
import com.sec.vo.BoardVO;
import com.sec.vo.MemberVO;

@Component
public class MemberDaoImpl implements MemberDao {
	//껍데기 impl을 먼저 만들고 alt+ shift+T
	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public MemberVO getMember(MemberVO member) {
		// TODO Auto-generated method stub
		MemberVO memberVO = new MemberVO();
		
		Optional<Member> memberDomain = memberRepo.findById(member.getId());
		
		//translate VO to entity
		//날짜는 ignore로 처리하여 값을 받지 않고 entity 생성돌때 같이 생성된다.
		if(memberDomain.isPresent()) {
			//와.. 안 된다.. optional은 getter호출을 지원하지 않는다.. mapping도 안됨..domain에 추가로 get()을 해줘야 한다.
			BeanUtils.copyProperties(memberDomain.get(), memberVO);
		}
		else
			memberVO = null;
		
		return memberVO;
	}
}
