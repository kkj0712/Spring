package com.myspring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
public class SampleCont {
	
	//admin���� �Ѿ���� (CustomLoginSuccessHanlder���� sendRedirect�� ���� admin���� �Ѿ����)
	//views/sample/admin.jsp�� �� ����
	//void�ϱ� GetMapping�� ���� admin.jsp�� ����.
	@GetMapping("admin")
	public void admin() {
		
	}
	
}
