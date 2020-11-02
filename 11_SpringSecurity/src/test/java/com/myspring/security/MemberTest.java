package com.myspring.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
@Log4j
public class MemberTest {
	@Autowired
	//@Setter(onMethod_=@Autowired)
	private PasswordEncoder pwencoder;
	
	@Setter(onMethod_=@Autowired)
	private DataSource ds;
	
	@Test
	public void testInsertMember() {
		String sql="insert into tbl_member(userid, userpw, username) values(?,?,?)";
		for(int i=0;i<100;i++) {
			Connection con=null;
			PreparedStatement ps=null;
			try {
				con=ds.getConnection();
				ps=con.prepareStatement(sql);
				ps.setString(2, pwencoder.encode("pw"+i)); //패스워드는 암호화 거쳐서 넣겠다.
				if(i<80) { //userid0~79까지는 일반사용자
					ps.setString(1, "user"+i);
					ps.setString(3, "일반사용자"+i);
				}else if(i<90) { //manager80~89까지는 운영자
					ps.setString(1, "manager"+i);
					ps.setString(3, "운영자"+i);
				}else { //admin90~99까지는 관리자
					ps.setString(1, "admin"+i);
					ps.setString(3, "관리자"+i);
				}
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(ps!=null) {try {ps.close();} catch (Exception e) {}}
				if(con!=null) {try {con.close();} catch (Exception e) {}}
			}
		}//end for
	}//testInsertMember
	
	@Test
	public void testInsertAuth() {
		String sql="insert into tbl_member_auth (userid, auth) values(?,?)";
		for(int i=0;i<100;i++) {
			Connection con=null;
			PreparedStatement ps=null;
			try {
				con=ds.getConnection();
				ps=con.prepareStatement(sql);
				if(i<80) { //userid0~79까지 권한은 ROLE_USER
					ps.setString(1, "user"+i);
					ps.setString(2, "ROLE_USER");
				}else if(i<90) { //manager80~89까지 권한은 ROLE_MEMBER
					ps.setString(1, "manager"+i);
					ps.setString(2, "ROLE_MEMBER");
				}else {	//admin90~99까지 권한은 ROLE_ADMIN
					ps.setString(1, "admin"+i);
					ps.setString(2, "ROLE_ADMIN");
				}
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(ps!=null) {try {ps.close();} catch (Exception e) {}}
				if(con!=null) {try {con.close();} catch (Exception e) {}}
			}
		}//end for
	}//testInsertAuth
}