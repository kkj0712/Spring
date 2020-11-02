package com.myspring.dto;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {
	private String userid;
	private String userpw;
	private String username;
	private boolean enabled;
	
	private String regDate;
	private String updateDate;
	private List<AuthDTO> authList; 
	//admin권한으로 들어온 사람은 user, manager, admin 세개의 권한을 가짐.
	//이런식으로 한 회원의 authList는 여러개임. 1:n 관계를 표현하기 위해 List에 담음
}
