package com.myspring.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.myspring.dto.MemberDTO;

//spring security에 user란 객체가 있기 때문에 조심해서 사용.
public class CustomUser extends User{
	private MemberDTO member;

	public CustomUser(String username, 
			String password, 
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(MemberDTO vo) {
		super(vo.getUserid(), 
			  vo.getUserpw(), 
			  vo.getAuthList().stream()
			  .map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
			  .collect(Collectors.toList())
		);
		this.member=vo;
		System.out.println(member);
	}
	
	public MemberDTO getMember() {
		return member;
	}
	
	public void setMember(MemberDTO member) {
		this.member=member;
	}

}
