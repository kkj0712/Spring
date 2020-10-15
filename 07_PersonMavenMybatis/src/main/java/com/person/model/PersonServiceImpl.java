package com.person.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDAO dao;
	
	//추가
	public void insert(Person person) {
		dao.dao_insert("insertData", person);
	}

	//전체보기
	public List<Person> list(HashMap<String, String> hm) {
		return dao.dao_list("listData", hm);
	}
	
	//인원 수 구하기
	public int count() {
		return dao.dao_count("countData");
	}
	
	//상세보기
	public Person detail(String id) {
		return dao.dao_detail("detailData", id);
	}

	//수정하기
	public void update(Person person) {
		dao.dao_update("updateData", person);
	}

	//삭제하기
	public void delete(String id) {
		dao.dao_delete("deleteData", id);
	}

}
