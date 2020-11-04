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
	//PasswordEncoder�� �������̽� ��ü. ��й�ȣ ��ȣȭ ��Ŵ
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
		//��ȣȭ�� ��й�ȣ
		String encPwd = passwordEncoder.encode(request.getParameter("password"));
		System.out.println("password: " + encPwd);
		
		//���� ������
		List<String> roleNames = new ArrayList<>();
		auth.getAuthorities().forEach(authority ->{
			roleNames.add(authority.getAuthority());
		});
		System.out.println("roleNames :" + roleNames);
		
		//���ѿ� ROLE_ADMIN�� ���ԵǾ� ������ admin �������� ����
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/security11/sample/admin");
			return;
		}
		//���ѿ� ROLE_MEMBER�� ���ԵǾ� ������ member �������� ����
		if(roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/security11/sample/member");
			return;
		}
		//�Ѵ� �ƴϸ� security11 �������� ����
		response.sendRedirect("/security11");
	}
}