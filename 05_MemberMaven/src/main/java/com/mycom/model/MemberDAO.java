package com.mycom.model;

import java.util.List;

public interface MemberDAO {
	//추가
	public void dao_insert(Member member);
	//전체보기
	public List<Member> dao_list(String field, String word);
	//상세보기
	public Member dao_findById(String id);
	//수정
	public void dao_update(Member member);
	//삭제
	public void dao_delete(String id);
}
