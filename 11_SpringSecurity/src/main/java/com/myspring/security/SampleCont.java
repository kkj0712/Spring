package com.myspring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
public class SampleCont {
	
	//admin으로 넘어오면 (CustomLoginSuccessHanlder에서 sendRedirect를 통해 admin으로 넘어오면)
	//views/sample/admin.jsp로 갈 것임
	//void니까 GetMapping이 오면 admin.jsp로 간다.
	@GetMapping("admin")
	public void admin() {
		
	}
	
}
