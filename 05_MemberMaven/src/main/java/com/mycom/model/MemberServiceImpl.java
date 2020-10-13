package com.mycom.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO dao;
	
	//�߰�
	public void insert(Member member) {
		dao.dao_insert(member);
	}

	//��ü
	public List<Member> list(String field, String word) {
		return dao.dao_list(field, word);
	}

	//��
	public Member findById(String id) {
		return dao.dao_findById(id);
	}

	//����
	public void update(Member member) {
		dao.dao_update(member);
	}

	//����
	public void delete(String id) {
		dao.dao_delete(id);
	}
}
