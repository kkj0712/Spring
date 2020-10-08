package org.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO{
	//db�����Ϸ��� template��ü�� �����������.
	@Autowired
	private JdbcTemplate template;
	
	//�߰�
	public void personInsert(PersonVO person) {
		String sql="insert into person values(?,?,?,?,?)";
		Object[]param=new Object[] {
			person.getId(),person.getName(),person.getPassword(),person.getGender(),person.getJob()
		};
		template.update(sql, param);
	}

	//����
	public void personUpdate(PersonVO person) {
		String sql="update person set job=?, gender=?, name=?, password=? where id=?";
		Object[]param=new Object[] {
			person.getJob(), person.getGender(), person.getName(), person.getPassword(), person.getId()	
		};
		template.update(sql, param);
	}

	//����
	public void personDelete(String id) {
		String sql="delete from person where id='"+id+"'";
		template.update(sql);
	}

	//��ü����
	public List<PersonVO> personList() {
		String sql="select * from person";
		List<PersonVO> personlist=template.query(sql, new RowMapper<PersonVO>() {
			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO p=new PersonVO();
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

	//�󼼺���
	public PersonVO personDetail(String id) {
		String sql="select * from person where id='"+id+"'";
		PersonVO person=template.queryForObject(sql, new RowMapper<PersonVO>() {
			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO p=new PersonVO();
				p.setId(rs.getString("id"));
				p.setJob(rs.getString("job"));
				p.setGender(rs.getString("gender"));
				p.setName(rs.getString("name"));
				p.setPassword(rs.getString("password"));
				return p;
			}
		});
		return person;
	}
}