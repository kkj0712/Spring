package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("test.go")
	public String test() {
		return "result";
	}
	
	@RequestMapping("test22.go")
	public String test22() {
		return "result22";
	}
	
}
