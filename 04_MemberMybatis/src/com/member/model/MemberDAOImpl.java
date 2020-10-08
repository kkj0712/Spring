package com.member.model;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	//sql����
	@Autowired
	private SqlSessionFactory sqlMapper;

	//�߰�
	public void dao_insert(String sql_Id, MemberVO member) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		sess.insert(sql_Id, member); //sql_Id="insertData"
		sess.commit();
	}

	//��ü����
	public List<MemberVO> dao_list(String sql_Id) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		List<MemberVO> memberlist=sess.selectList(sql_Id);
		return memberlist;
	}

	//�󼼺���
	public MemberVO dao_view(String sql_Id, String id) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		MemberVO member=sess.selectOne(sql_Id, id);
		return member;
	}

	//����
	public void dao_update(String sql_Id, MemberVO member) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		sess.update(sql_Id, member);
		sess.commit();
	}

	//����
	public void dao_delete(String sql_Id, String id) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		sess.delete(sql_Id, id);
		sess.commit();
	}
}