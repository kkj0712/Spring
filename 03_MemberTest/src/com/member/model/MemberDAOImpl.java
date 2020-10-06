package com.member.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private JdbcTemplate template;
	
	//�߰�
	public void insert(MemberDTO user) {
		String sql="insert into springmember values(?,?,?,?,?,sysdate)";
		Object[]param=new Object[] {
				user.getId(), user.getPass(), user.getName(), user.getAddr(), user.getMemo()
		};
		template.update(sql, param);
	}

	//��ü����
	public List<MemberDTO> getMemberList() {
		String sql="select * from springmember";
		List<MemberDTO> memberlist=template.query(sql, new RowMapper<MemberDTO>() {
			@Override
			public MemberDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberDTO m=new MemberDTO();
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setAddr(rs.getString("addr"));
				m.setMemo(rs.getString("memo"));
				m.setReg_date(rs.getString("reg_date"));
				return m;
			}
		});
		return memberlist;
	}

	//�󼼺���
	public MemberDTO findById(String id) {
		String sql="select * from springmember where id='"+id+"'";
		MemberDTO m=template.queryForObject(sql, new RowMapper<MemberDTO>() {
			@Override
			public MemberDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberDTO user=new MemberDTO();
				user.setAddr(rs.getString("addr"));
				user.setId(rs.getString("id"));
				user.setMemo(rs.getString("memo"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setReg_date(rs.getString("reg_date"));
				return user;
			}
		});
		return m;
	}

	
	//����
	public void update(MemberDTO user) {
		String sql="update springmember set pass=?, name=?, addr=?, memo=? where id=?";
		Object[] param=new Object[] {
				user.getPass(), user.getName(), user.getAddr(), user.getMemo(), user.getId()
		};
		template.update(sql, param);
	}

	//����
	public void delete(String id) {
		String sql="delete from springmember where id='"+id+"'";
		template.update(sql);
	}

}
