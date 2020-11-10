package com.example.demo6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo6.model.StarterBoard;

public interface BoardRepository extends JpaRepository<StarterBoard, Long>{

}
