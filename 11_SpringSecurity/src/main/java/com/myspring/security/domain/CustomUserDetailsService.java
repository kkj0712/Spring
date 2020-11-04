package com.myspring.security.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.myspring.dto.MemberDTO;
import com.myspring.mapper.MemberMapper;

public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private MemberMapper memberMapper;

	//loadUserByUsername �޼ҵ� �����ϸ鼭 ������ ��Ĵ�� ������ ������. 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberDTO member = memberMapper.read(username);
		//��ü�� ������ CustomUser ������ �ٲ۴�.
		return member==null?null : new CustomUser(member);
	}
}