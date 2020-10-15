package com.member.mytest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	@RequestMapping("")
	public void basic() {
		System.out.println("basic");
	}
}
