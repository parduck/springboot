package com.sec.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.admin.biz.BoardBiz;
import com.sec.domain.Search;
import com.sec.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	//alt+ shift+T
	
	@Autowired
	private BoardBiz boardBiz;
	
	
	@Override
	public List<BoardVO> getBoardList(Search search){
		return (List<BoardVO>)boardBiz.getBoardList(search);
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
