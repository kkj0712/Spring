package com.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO dao;
	
	//�߰��ϱ�
	public void insert(Member member) {
		dao.dao_insert("insertData", member);
	}

	//��ü����
	public List<Member> list(String field, String word) {
		return dao.dao_list("listData", field, word);
	}

	//�󼼺���
	public Member findById(String id) {
		return dao.dao_findById("viewData", id);
	}

	//�����ϱ�
	public void update(Member member) {
		dao.dao_update("updateData",member);
	}

	//�����ϱ�
	public void delete(String id) {
		dao.dao_delete("deleteData", id);
	}

}
