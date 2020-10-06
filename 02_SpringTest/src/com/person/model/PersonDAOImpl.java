package com.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO{
	@Autowired
	private JdbcTemplate template;
	
	//�߰�
	public void personInsert(Person p) {
		String sql="insert into person values(?,?,?,?,?)";
		Object[]param=new Object[] {
				p.getId(),p.getName(),p.getPassword(),p.getGender(),p.getJob()
		};
		template.update(sql, param);
	}

	//��ü����
	public List<Person> personList() {
		String sql="select * from person";
		List<Person> personlist=template.query(sql, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int arg1) throws SQLException {
				Person p=new Person();
				p.setGender(rs.getString("gender"));
				p.setId(rs.getString("id"));
				p.setJob(rs.getString("job"));
				p.setName(rs.getString("name"));
				p.setPassword(rs.getString("password"));
				return p;
			}
		});
		return personlist;
	}

	//�����ϱ�
	public void personUpdate(Person p) {
		String sql="update person set job=?, gender=?, name=?, password=? where id=?";
		Object[] param=new Object[] {
				p.getJob(),p.getGender(),p.getName(),p.getPassword(),p.getId()
		};
		template.update(sql, param);
	}

	//�����ϱ�
	public void personDelete(String id) {
		String sql="delete from person where id='"+id+"'";
		template.update(sql);
	}

	//�󼼺���
	public Person personView(String id) {
		String sql="select * from person where id='"+id+"'";
		Person p=template.queryForObject(sql, new RowMapper<Person>() {
			@Override
			public Person mapRow(ResultSet rs, int arg1) throws SQLException {
				Person user=new Person();
				user.setGender(rs.getString("gender"));
				user.setId(rs.getString("id"));
				user.setJob(rs.getString("job"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		return p;
	}

}
