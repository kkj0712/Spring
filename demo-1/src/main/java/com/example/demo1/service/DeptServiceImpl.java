package com.example.demo1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo1.dao.DeptDAO;
import com.example.demo1.vo.DeptVO;

import lombok.Builder;

@Service
public class DeptServiceImpl implements DeptService{
	//Autowired안써도 됨.
	private DeptDAO deptDao;
	
	@Builder
	public DeptServiceImpl(DeptDAO deptDao) {
		super();
		this.deptDao=deptDao;
	}
	
	@Override
	public List<DeptVO> list() {
		return deptDao.list();
	}

}
