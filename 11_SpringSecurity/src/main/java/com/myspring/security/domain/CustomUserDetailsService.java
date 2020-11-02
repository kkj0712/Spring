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
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberDTO member=memberMapper.read(username);
		
		return member==null? null:new CustomUser(member); //spring이 인정해주는 애를 내가 만든 애로 바꿈.
	}

}
