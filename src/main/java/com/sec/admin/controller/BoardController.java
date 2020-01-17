package com.sec.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sec.admin.domain.Board;
import com.sec.admin.domain.BoardVO;
//is this work well??
import com.sec.persistence.BoardRepository;

import com.sec.admin.service.BoardService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/hello")
	public void hello(Model model) {
		System.out.println("===>타임리프 called..");
		model.addAttribute("greeting","Hello 타임리프...");
	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList",boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board",boardService.getBoard(board));
		return "getBoard";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
}
