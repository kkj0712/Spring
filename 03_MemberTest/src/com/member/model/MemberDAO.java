package com.member.model;

import java.util.List;

public interface MemberDAO {

	//추가
	public void insert(MemberDTO user);
	//전체보기
	public List<MemberDTO> getMemberList();
	//상세보기
	public MemberDTO findById(String id);
	//수정
	public void update(MemberDTO user);
	//삭제
	public void delete(String id);
}
