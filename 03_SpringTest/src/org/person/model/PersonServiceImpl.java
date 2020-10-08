package org.person.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDAO dao;
	
	//추가
	public void person_insert(PersonVO person) {
		dao.personInsert(person);
	}

	//수정
	public void person_update(PersonVO person) {
		dao.personUpdate(person);
	}

	//삭제
	public void person_delete(String id) {
		dao.personDelete(id);
	}

	//전체보기
	public List<PersonVO> person_list() {
		return dao.personList();
	}

	//상세보기
	public PersonVO person_detail(String id) {
		return dao.personDetail(id);
	}
	
}
