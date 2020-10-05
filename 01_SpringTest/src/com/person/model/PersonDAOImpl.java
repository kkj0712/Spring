package com.person.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDAOImpl implements PersonDAO{
	private JdbcTemplate template;
	
	//setter
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//�߰��ϱ�
	public void personInsert(PersonDTO person) {
		String sql="insert into person values(?,?,?,?,?)";
		Object[] param=new Object[] {
			person.getId(),person.getName(),person.getPassword(),person.getGender(),
			person.getJob()
		};
		template.update(sql,param);
	}

	//��ü����
	public List<PersonDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	//�����ϱ�
	public void personUpdate(String id) {
		// TODO Auto-generated method stub
		
	}

	//�����ϱ�
	public void personDelete(String id) {
		// TODO Auto-generated method stub
		
	}

	//�󼼺���
	public PersonDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
