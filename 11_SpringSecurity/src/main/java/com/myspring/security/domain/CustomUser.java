package com.myspring.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.myspring.dto.MemberDTO;

//spring security�� user�� ��ü�� �ֱ� ������ �����ؼ� ���.
public class CustomUser extends User{
	private MemberDTO member;

	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public CustomUser(MemberDTO vo) {
		super(vo.getUserid(), 
			  vo.getUserpw(), 
			  vo.getAuthList().stream()
			  .map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
			  .collect(Collectors.toList())
		);
		this.member=vo;
	}
	
	public MemberDTO getMember() {
		return member;
	}
	
	public void setMember(MemberDTO member) {
		this.member=member;
	}

}