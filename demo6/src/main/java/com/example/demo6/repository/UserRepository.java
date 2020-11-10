package com.example.demo6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo6.model.StarterUser;

public interface UserRepository extends JpaRepository<StarterUser, Long> {

}
