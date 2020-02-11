package com.sec.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sec.domain.Board;
import com.sec.domain.Member;
import com.sec.repo.BoardRepository;
import com.sec.vo.BoardVO;
import com.sec.vo.MemberVO;

@Component
public class BoardDaoImpl implements BoardDao {
	//껍데기 impl을 먼저 만들고 alt+ shift+T
	
	@Autowired
	private BoardRepository boardRepo;
	
	//entity를 어떻게 VO로 바꾸나..
	//BeanUtils 객체가 있습니다. Source 객체에 있는 필드들의 값을 target객체의 필드에 똑같이 set 해주는 역할
	
	@Override
	public List<BoardVO> getBoardList(BoardVO board){

		List<BoardVO> boardVOList = new ArrayList<BoardVO>();
		
		//JPA 쿼리
		List<Board> boardList =boardRepo.findAll();
		
		//convert entity to VO
		for (int i = 0; i < boardList.size(); i++) { 
			BoardVO boardVO = new BoardVO();
			MemberVO memberVO = new MemberVO();
			BeanUtils.copyProperties(boardList.get(i), boardVO);
			BeanUtils.copyProperties(boardList.get(i).getMember(), memberVO);
			boardVO.setMember(memberVO);
			boardVOList.add(boardVO); 
		}
		 
		return boardVOList;
	}
	
	@Override
	public void insertBoard(BoardVO board) {
		//translate VO to entity
		//날짜는 ignore로 처리하여 값을 받지 않고 entity 생성돌때 같이 생성된다.
		Board boardDomain = new Board();
		Member memberDomain = new Member();
		BeanUtils.copyProperties(board, boardDomain,"createDate");
		BeanUtils.copyProperties(board.getMember(), memberDomain);
		boardDomain.setMember(memberDomain);
		
	System.out.println("asis======="+board.toString());
	System.out.println("tobe======="+boardDomain.toString());
		
		
		boardRepo.save(boardDomain);
	}
	
	@Override
	public BoardVO getBoard(BoardVO board) {
		//translate  entity to Vo
		BoardVO boardVO = new BoardVO();
		MemberVO memberVO = new MemberVO();
		
		BeanUtils.copyProperties(boardRepo.findById(board.getSeq()).get(), boardVO);
		BeanUtils.copyProperties(boardRepo.findById(board.getSeq()).get().getMember(), memberVO);
		boardVO.setMember(memberVO);
		
		return boardVO;
	}
	
	@Override
	public void updateBoard(BoardVO board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
		
	}
	
	@Override
	public void deleteBoard(BoardVO board) {
		boardRepo.deleteById(board.getSeq());
	}
}
