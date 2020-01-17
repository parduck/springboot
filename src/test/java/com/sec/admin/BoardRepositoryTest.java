package com.sec.admin;

import java.util.Date;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;

import com.sec.admin.domain.Board;
import com.sec.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {

	
	@Autowired
	private BoardRepository boardRepo;
	
	
	  @Test public void testInsertBoard() { Board board = new Board();
	 // board.setTitle("first test"); board.setMemberId("tester");
	  board.setContent("is it right??"); board.setCreateDate(new Date());
	  board.setCnt(0L);
	  
	  boardRepo.save(board); }
	 
	
	
	  @Test public void testGetBoard() { Board board =
	  boardRepo.findById(1L).get(); System.out.println(board.toString()); }
	  
	  @Test public void testUpdateBoard() {
		  System.out.println("====1번글 조회===");
		  Board board = boardRepo.findById(1L).get();
		  
		  System.out.println("===1번글 수정===");
		  board.setTitle("수정된 제목");
		  boardRepo.save(board);
	  }
	 
}
