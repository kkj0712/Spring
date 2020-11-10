package com.example.demo6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo6.model.StarterUser;

public interface UserRepository extends JpaRepository<StarterUser, Long> {

	@Query(value="select count(*) from starter_user where userid=?1", nativeQuery = true)
	public Long findByUserid(String userid);
}
