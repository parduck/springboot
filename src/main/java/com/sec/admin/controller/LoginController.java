package com.sec.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sec.admin.service.MemberService;
import com.sec.vo.MemberVO;

@SessionAttributes("member")
@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;
	
//	@GetMapping("/login")
//	public void loginView() {
//		
//	}
	
	@PostMapping("/login")
	public String login(MemberVO member, Model model) {
		MemberVO findMember = memberService.getMember(member);
		if(findMember != null &&findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member",findMember);
			return "forward:getBoardList";
		}else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}
}
