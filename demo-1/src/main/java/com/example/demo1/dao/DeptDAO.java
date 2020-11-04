package com.example.demo1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo1.vo.DeptVO;

@Mapper
public interface DeptDAO {
	public List<DeptVO> list();
}
