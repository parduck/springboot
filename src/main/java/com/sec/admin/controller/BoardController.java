package com.sec.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sec.admin.domain.BoardVO;
//is this work well??
import com.sec.admin.domain.BoardVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
public class BoardController {

	public BoardController() {
		System.out.println("===>BoardController created..");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello:" + name; //test
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("test");
		board.setWriter("kim");
		board.setContent("test contents123...");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board;
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for (int i=1;i<=10;i++) {
			BoardVO board = new BoardVO();
		
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
}
 