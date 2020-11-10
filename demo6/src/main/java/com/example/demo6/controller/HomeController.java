package com.example.demo6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo6.model.StarterUser;
import com.example.demo6.service.BoardService;
import com.example.demo6.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService uservice;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//uInsert폼으로 이동
	@GetMapping("insert")
	public String insert() {
		return "uInsert";
	}
	
	//아이디중복확인
	@GetMapping("idCheck")
	@ResponseBody
	public String idcheck(String userid) {
		String idCountStr=uservice.id_Check(userid);
		return idCountStr;
	}
	
	//회원가입
	@PostMapping("insert")
	public String insert(StarterUser user) {
		uservice.save(user);
		return "redirect:list";
	}
	
	//uList로 이동
	@GetMapping("list")
	public String list(Model model,
			@PageableDefault(size=3, sort="unum", direction = Sort.Direction.DESC)
			Pageable pageable) {
		Page<StarterUser> ulist=uservice.list(pageable);
		model.addAttribute("ulist", ulist);
		return "uList";
	}
	
	//상세보기 폼으로 이동
	@GetMapping("{unum}")
	public String findByUnum(@PathVariable Long unum, Model model) {
		model.addAttribute("user", uservice.detail(unum));
		return "uView";
	}
	
	//수정하기
	@PutMapping("update/{unum}")
	@ResponseBody
	public String update(@PathVariable Long unum, @RequestBody StarterUser user) {
		uservice.update(user);
		String idStr=user.getUserid().toString();
		return idStr;
	}
	
	//삭제하기
	@DeleteMapping("delete/{unum}")
	@ResponseBody
	public String delete(@PathVariable Long unum, @RequestBody StarterUser user) {
		uservice.delete(unum);
		String idStr=user.getUserid().toString();
		return idStr;
	}
}
