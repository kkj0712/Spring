package com.member.model;

import java.util.List;

public interface MemberDAO {
	//추가
	public void dao_insert(String sql_Id, MemberVO member);
	//전체보기
	public List<MemberVO> dao_list(String sql_Id);
	//상세보기
	public MemberVO dao_view(String sql_Id, String id);
	//수정
	public void dao_update(String sql_Id, MemberVO member);
	//삭제
	public void dao_delete(String sql_Id, String id);
}