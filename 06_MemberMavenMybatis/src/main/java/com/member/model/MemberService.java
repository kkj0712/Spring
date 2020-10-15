package com.member.model;

import java.util.HashMap;
import java.util.List;

public interface MemberService {
	//추가
	public void insert(Member member);
	//전체보기
	public List<Member> list(HashMap<String, String> hm);
	//상세보기
	public Member findById(String id);
	//수정
	public void update(Member member);
	//삭제
	public void delete(String id);
}
