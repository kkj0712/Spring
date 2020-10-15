package com.person.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO{
	@Autowired
	private SqlSessionFactory sqlMapper;

	//추가하기
	public void dao_insert(String sql_Id, Person person) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		sess.insert(sql_Id, person);
		sess.commit();
	}

	//전체보기
	public List<Person> dao_list(String sql_Id, HashMap<String, String> hm) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		List<Person> personlist=sess.selectList(sql_Id, hm);
		return personlist;
	}

	//상세보기
	public Person dao_detail(String sql_Id, String id) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		Person person=sess.selectOne(sql_Id, id);
		return person;
	}

	//수정하기
	public void dao_update(String sql_Id, Person person) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		sess.update(sql_Id, person);
	}

	//삭제하기
	public void dao_delete(String sql_Id, String id) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		sess.delete(sql_Id, id);
	}

	//인원수
	public int dao_count(String sql_Id) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		int count=(Integer)sess.selectOne(sql_Id);
		return count;
	}
}