package com.member.model;

import java.util.HashMap;
import java.util.List;

public interface MemberDAO {
	//추가
	public void dao_insert(String sql_Id, Member member);
	//전체보기
	public List<Member> dao_list(String sql_Id, HashMap<String, String> hm);
	//상세보기
	public Member dao_findById(String sql_Id, String id);
	//수정
	public void dao_update(String sql_Id, Member member);
	//삭제
	public void dao_delete(String sql_Id, String id);
}
