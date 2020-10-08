package com.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	//dao연결
	@Autowired
	private MemberDAO mDao;
	
	//추가
	public void insert(MemberVO member) {
		mDao.dao_insert("insertData", member);
	}

	//전체보기
	public List<MemberVO> list() {
		return mDao.dao_list("listData");
	}

	//상세보기
	public MemberVO view(String id) {
		return mDao.dao_view("viewData", id);
	}

	//수정
	public void update(MemberVO member) {
		mDao.dao_update("updateData", member);
	}

	//삭제
	public void delete(String id) {
		mDao.dao_delete("deleteData", id);
	}

}
