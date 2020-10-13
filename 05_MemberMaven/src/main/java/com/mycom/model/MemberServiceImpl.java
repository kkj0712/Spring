package com.mycom.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO dao;
	
	//추가
	public void insert(Member member) {
		dao.dao_insert(member);
	}

	//전체
	public List<Member> list(String field, String word) {
		return dao.dao_list(field, word);
	}

	//상세
	public Member findById(String id) {
		return dao.dao_findById(id);
	}

	//수정
	public void update(Member member) {
		dao.dao_update(member);
	}

	//삭제
	public void delete(String id) {
		dao.dao_delete(id);
	}
}
