package com.sec.admin.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sec.exception.BoardNotFoundException;

@Controller
public class ExceptionController {

	@RequestMapping("/boardError")
	public String boardError() throws BoardNotFoundException {
		throw new BoardNotFoundException("not found ");
	}
	
	@RequestMapping("/illegalArgumentError")
	public String illegalArgumentError() {
		throw new IllegalArgumentException("illegal");
	}
	
	@RequestMapping("/sqlError")
	public String sqlError() throws SQLException{
		throw new SQLException("SQL ERROR");
	}
	
	@ExceptionHandler(SQLException.class)
	public String numberFormatError(Exception exception, Model model) {
		model.addAttribute("exception",exception);
		return "/errors/sqlError";
	}

}
