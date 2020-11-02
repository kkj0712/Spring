package com.myspring.service;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//내가 만든 메서드가 잘 작동되는지 먼저 테스트 한 뒤 톰캣을 통해 실행해보기 위해..
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //이 파일 참고해서 테스트해라.
@Log4j
public class DataSourceTest {
	@Setter(onMethod_= {@Autowired})
	private DataSource dataSource; //root-context의 sqlSessionFactoryBean의 이름과 동일해야함.
	
	@Test
	public void testConnection() {
		try(Connection con=dataSource.getConnection()){
			log.info(con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
