package com.sec.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sec.domain.Board;
import com.sec.domain.BoardV;
import com.sec.repo.BoardRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
public class RestBoardController {

	public RestBoardController() {
		System.out.println("===>BoardController created..");
	}
	

	
	@GetMapping("/getRestBoard")
	public BoardV getBoard() {
		BoardV board = new BoardV();
		board.setSeq(1);
		board.setTitle("test");
		board.setWriter("kim");
		board.setContent("test contents123...");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board;
	}
	
	@GetMapping("/getRestBoardList")
	public List<BoardV> getBoardList() {
		List<BoardV> boardList = new ArrayList<BoardV>();
		for (int i=1;i<=10;i++) {
			BoardV board = new BoardV();
		
			board.setSeq(i);
			board.setTitle("test"+i);
			board.setWriter("kim");
			board.setContent(i+ "번 test contents...");
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}
	
	@Autowired
	private BoardRepository boardRepo;
	
	@GetMapping("/setBoardDB")
	public List<Board> setBoardDB() {		
		
		Board board = new Board();
		board.setSeq(1L);
		board.setTitle("test");
		//board.setId("kim");
		board.setContent("test contents123...");
		board.setCreateDate(new Date());
		board.setCnt(0L);
		
		boardRepo.save(board);
		
		return boardRepo.findAll();
	}
	
	@GetMapping("/getBoardDB")
	public List<Board> getBoardDB() {		
		
		
		return boardRepo.findAll();
	}
}
 