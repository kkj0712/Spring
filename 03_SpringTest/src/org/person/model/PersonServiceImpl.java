package org.person.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDAO dao;
	
	//�߰�
	public void person_insert(PersonVO person) {
		dao.personInsert(person);
	}

	//����
	public void person_update(PersonVO person) {
		dao.personUpdate(person);
	}

	//����
	public void person_delete(String id) {
		dao.personDelete(id);
	}

	//��ü����
	public List<PersonVO> person_list() {
		return dao.personList();
	}

	//�󼼺���
	public PersonVO person_detail(String id) {
		return dao.personDetail(id);
	}
	
}
