package com.example.demo6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo6.dto.CommentDTO;
import com.example.demo6.model.StarterComment;

public interface CommentRepository extends JpaRepository<StarterComment, Long> {

	@Query("SELECT sc from StarterComment sc where bnum=?1")
	List<StarterComment> findByBnum(Long bnum);
	
	@Modifying
	@Query(value="insert into starter_comment(bnum, content, regdate) values (?1, ?2, now())", nativeQuery = true)
	public void commentInsert(Long bnum, String content);
	
	
}
