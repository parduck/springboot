package com.sec.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sec.admin.domain.Board;
import com.sec.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	//alt+ shift+T
	
	@Autowired
	private BoardRepository boardRepo;
	
	
	@Override
	public List<Board> getBoardList(Board board){
		return (List<Board>)boardRepo.findAll();
	}
	
	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	
	@Override
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}
	
	@Override
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
		
	}
	
	@Override
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
	}

}
