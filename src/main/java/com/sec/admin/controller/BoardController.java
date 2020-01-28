package com.sec.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sec.admin.service.BoardService;
import com.sec.domain.Board;
import com.sec.domain.BoardV;
import com.sec.repo.BoardRepository;
import com.sec.vo.BoardVO;
import com.sec.vo.MemberVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SessionAttributes("member")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/hello")
	public void hello(Model model) {
		System.out.println("===>타임리프 called..");
		model.addAttribute("greeting","Hello 타임리프...");
	}
	@ModelAttribute("member")
	public MemberVO setMember() {
		return new MemberVO();
	}
	@RequestMapping("/getBoardList")
	public String getBoardList(@ModelAttribute("member") MemberVO member, Model model, BoardVO board) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		List<BoardVO> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList",boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") MemberVO member,BoardVO board) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") MemberVO member,BoardVO board, Model model) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		model.addAttribute("board",boardService.getBoard(board));
		return "getBoard";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member") MemberVO member,BoardVO board) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") MemberVO member,BoardVO board) {
		if(member.getId() ==null) {
			return "redirect:login";
		}
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
}
