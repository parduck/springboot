package com.sec.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	@GetMapping("/")
	public String index() {
		System.out.println("index request..");
		return "index";
	}
	
	@GetMapping("/member")
	public void forMember() {
		System.out.println("Member request..");
	}
	
	@GetMapping("/manager")
	public void forManager() {
		System.out.println("Manager request..");
	}
	
	@GetMapping("/admin")
	public void forAdmin() {
		System.out.println("Admin request..");
	}
	
	@GetMapping("/login")
	public void login() {
//		System.out.println("==============login request..");
//		return "redirect:loginSuccess.html";
	}
	
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
//		System.out.println("==============loginSucess request..");
//		return "redirect:loginSuccess";
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied() {
		
	}
	

}
