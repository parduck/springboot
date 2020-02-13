package com.sec.admin.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sec.admin.service.BoardService;
import com.sec.config.SecurityUser;
import com.sec.domain.Search;
import com.sec.vo.BoardVO;
import com.sec.vo.MemberVO;

//@SessionAttributes("member")
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
//	@RequestMapping("/getBoardList")
//	public String getBoardList(@ModelAttribute("member") MemberVO member, Model model, BoardVO board) {
//		if(member.getId() ==null) {
//			System.out.println("===>"+member.toString());
//			return "redirect:login";
//		}
//		List<BoardVO> boardList = boardService.getBoardList(board);
//		model.addAttribute("boardList",boardList);
//		return "getBoardList";
//	}
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Search search) {

		if(search.getSearchCondition() ==null)
			search.setSearchCondition("TITLE");
		if(search.getSearchKeyword()==null)
			search.setSearchKeyword("");
		
		List<BoardVO> boardList = boardService.getBoardList(search);
		model.addAttribute("boardList",boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
//	@PostMapping("/insertBoard")
//	public String insertBoard(@ModelAttribute("member") MemberVO member,BoardVO board) {
//		if(member.getId() ==null) {
//			return "redirect:login";
//		}
//		boardService.insertBoard(board);
//		return "redirect:getBoardList";
//	}
	@PostMapping("/insertBoard")
	public String insertBoard(BoardVO board,@AuthenticationPrincipal SecurityUser principal) {
		System.out.println("insert====called");
		MemberVO memberVo = new MemberVO();
		BeanUtils.copyProperties(principal.getMember(), memberVo);
		
		System.out.println("insert===="+principal.getMember().toString());
		board.setMember(memberVo);
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
//	@GetMapping("/getBoard")
//	public String getBoard(@ModelAttribute("member") MemberVO member,BoardVO board, Model model) {
//		if(member.getId() ==null) {
//			return "redirect:login";
//		}
//		model.addAttribute("board",boardService.getBoard(board));
//		return "getBoard";
//	}
	@GetMapping("/getBoard")
	public String getBoard(BoardVO board, Model model) {
	
		model.addAttribute("board",boardService.getBoard(board));
		return "getBoard";
	}
	
//	@PostMapping("/updateBoard")
//	public String updateBoard(@ModelAttribute("member") MemberVO member,BoardVO board) {
//		if(member.getId() ==null) {
//			return "redirect:login";
//		}
//		boardService.updateBoard(board);
//		return "forward:getBoardList";
//	}
//
//	@GetMapping("/deleteBoard")
//	public String deleteBoard(@ModelAttribute("member") MemberVO member,BoardVO board) {
//		if(member.getId() ==null) {
//			return "redirect:login";
//		}
//		boardService.deleteBoard(board);
//		return "forward:getBoardList";
//	}
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO board) {
	
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(BoardVO board) {
	
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
}
