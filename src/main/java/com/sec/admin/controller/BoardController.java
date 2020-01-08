package com.sec.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//is this work well??
@RestController
public class BoardController {

	public BoardController() {
		System.out.println("===>BoardController created..");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello:" + name; //test
	}
}
 