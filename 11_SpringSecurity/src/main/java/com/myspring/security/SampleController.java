package com.myspring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class SampleController {
	@GetMapping("/customLogin")
	public void loginInput() {
		log.info("customLogin");
	}
	
	@GetMapping("/customLogout")
	public void logout() {
	 	log.info("customLogout");
	}	
}
