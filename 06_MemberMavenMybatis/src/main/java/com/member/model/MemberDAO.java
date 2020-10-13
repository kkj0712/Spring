package com.member.model;

import java.util.List;

public interface MemberDAO {
	//�߰�
	public void dao_insert(String sql_Id, Member member);
	//��ü����
	public List<Member> dao_list(String sql_Id, String field, String word);
	//�󼼺���
	public Member dao_findById(String sql_Id, String id);
	//����
	public void dao_update(String sql_Id, Member member);
	//����
	public void dao_delete(String sql_Id, String id);
}
