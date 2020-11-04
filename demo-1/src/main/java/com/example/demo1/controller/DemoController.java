package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo1.service.DeptService;
import com.example.demo1.vo.DeptVO;

@Controller
public class DemoController {
	//@Autowired
	private DeptService deptService;
	
	public DemoController(DeptService deptService) {
		this.deptService=deptService;
	}
	
	@GetMapping("/")
	public String index() {
		return "home";
	}
	
	@GetMapping("list")
	public @ResponseBody List<DeptVO> getList() {
		return deptService.list();
	}
	
	
}
