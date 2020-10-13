package com.mycom.model;

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
	
	//추가
	public void dao_insert(Member member) {
		String sql="insert into springmember values(?,?,?,?,?,sysdate)";
		Object[] param=new Object[] {
			member.getId(), member.getPass(), member.getName(), member.getAddr(), member.getMemo()	
		};
		template.update(sql, param);
	}

	//전체
	public List<Member> dao_list(String field, String word) {
		String sql="";
		if(word.equals("")) {
			sql="select * from springmember";
		}else {
			sql="select * from springmember where "+field+" like '%"+word+"%'";
		}
		List<Member> memberlist=template.query(sql, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member=new Member();
				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
				member.setMemo(rs.getString("memo"));
				member.setReg_date(rs.getString("reg_date"));
				return member;
			}
		});
		return memberlist;
	}

	//상세
	public Member dao_findById(String id) {
		String sql="select * from springmember where id='"+id+"'";
		Member member=template.queryForObject(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member m=new Member();
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setAddr(rs.getString("addr"));
				m.setMemo(rs.getString("memo"));
				m.setReg_date(rs.getString("reg_date"));
				return m;
			}
			
		});
		return member;
	}

	//수정
	public void dao_update(Member member) {
		String sql="update springmember set pass=?, name=?, addr=?, memo=? where id=?";
		Object[] param=new Object[] {
				member.getPass(), member.getName(), member.getAddr(), member.getMemo(), member.getId()
		};
		template.update(sql, param);
	}

	//삭제
	public void dao_delete(String id) {
		String sql="delete from springmember where id='"+id+"'";
		template.update(sql);
	}

}
