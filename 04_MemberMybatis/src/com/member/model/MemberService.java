package com.member.model;

import java.util.List;

public interface MemberService {
	//추가
	public void insert(MemberVO member);
	//전체보기
	public List<MemberVO> list();
	//상세보기
	public MemberVO view(String id);
	//수정
	public void update(MemberVO member);
	//삭제
	public void delete(String id);
}
