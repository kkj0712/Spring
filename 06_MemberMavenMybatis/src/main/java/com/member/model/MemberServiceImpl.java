package com.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO dao;
	
	//추가하기
	public void insert(Member member) {
		dao.dao_insert("insertData", member);
	}

	//전체보기
	public List<Member> list(String field, String word) {
		return dao.dao_list("listData", field, word);
	}

	//상세보기
	public Member findById(String id) {
		return dao.dao_findById("viewData", id);
	}

	//수정하기
	public void update(Member member) {
		dao.dao_update("updateData",member);
	}

	//삭제하기
	public void delete(String id) {
		dao.dao_delete("deleteData", id);
	}

}
