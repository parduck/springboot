package com.sec.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sec.admin.biz.BoardBiz;
import com.sec.domain.Board;
import com.sec.repo.BoardRepository;
import com.sec.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	//alt+ shift+T
	
	@Autowired
	private BoardBiz boardBiz;
	
	
	@Override
	public List<BoardVO> getBoardList(BoardVO board){
		return (List<BoardVO>)boardBiz.getBoardList(board);
	}
	
	@Override
	public void insertBoard(BoardVO board) {
		boardBiz.insertBoard(board);
	}
	
	@Override
	public BoardVO getBoard(BoardVO board) {
		return boardBiz.getBoard(board);
	}
	
	@Override
	public void updateBoard(BoardVO board) {
		boardBiz.updateBoard(board);
		
	}
	
	@Override
	public void deleteBoard(BoardVO board) {
		boardBiz.deleteBoard(board);
	}

}
