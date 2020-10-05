package com.person.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDAOImpl implements PersonDAO{
	private JdbcTemplate template;
	
	//setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//추가하기
	public void personInsert(PersonDTO person) {
		String sql="insert into person values(?,?,?,?,?)";
		Object[] param=new Object[] {
			person.getId(),person.getName(),person.getPassword(),person.getGender(),
			person.getJob()
		};
		template.update(sql,param);
	}

	//전체보기
	public List<PersonDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	//수정하기
	public void personUpdate(String id) {
		// TODO Auto-generated method stub
		
	}

	//삭제하기
	public void personDelete(String id) {
		// TODO Auto-generated method stub
		
	}

	//상세보기
	public PersonDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
