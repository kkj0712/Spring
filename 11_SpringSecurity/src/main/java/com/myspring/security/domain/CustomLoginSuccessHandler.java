package com.myspring.security.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

//@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	//PasswordEncoder는 인터페이스 객체. 비밀번호 암호화 시킴
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
		//암호화된 비밀번호
		String encPwd = passwordEncoder.encode(request.getParameter("password"));
		System.out.println("password: " + encPwd);
		
		//권한 가져와
		List<String> roleNames = new ArrayList<>();
		auth.getAuthorities().forEach(authority ->{
			roleNames.add(authority.getAuthority());
		});
		System.out.println("roleNames :" + roleNames);
		
		//권한에 ROLE_ADMIN이 포함되어 있으면 admin 페이지로 가라
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/security11/sample/admin");
			return;
		}
		//권한에 ROLE_MEMBER가 포함되어 있으면 member 페이지로 가라
		if(roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/security11/sample/member");
			return;
		}
		//둘다 아니면 security11 페이지로 가라
		response.sendRedirect("/security11");
	}
}