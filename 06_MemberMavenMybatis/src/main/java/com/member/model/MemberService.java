package com.member.model;

import java.util.HashMap;
import java.util.List;

public interface MemberService {
	//�߰�
	public void insert(Member member);
	//��ü����
	public List<Member> list(HashMap<String, String> hm);
	//�󼼺���
	public Member findById(String id);
	//����
	public void update(Member member);
	//����
	public void delete(String id);
}
