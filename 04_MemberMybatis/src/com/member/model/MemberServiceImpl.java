package com.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	//dao����
	@Autowired
	private MemberDAO mDao;
	
	//�߰�
	public void insert(MemberVO member) {
		mDao.dao_insert("insertData", member);
	}

	//��ü����
	public List<MemberVO> list() {
		return mDao.dao_list("listData");
	}

	//�󼼺���
	public MemberVO view(String id) {
		return mDao.dao_view("viewData", id);
	}

	//����
	public void update(MemberVO member) {
		mDao.dao_update("updateData", member);
	}

	//����
	public void delete(String id) {
		mDao.dao_delete("deleteData", id);
	}

}
