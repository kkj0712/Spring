package com.example.demo5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo5.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
