package com.example.demo6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo6.model.StarterBoard;
import com.example.demo6.model.StarterUser;
import com.example.demo6.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService bservice;
	
	//추가폼으로 이동
	@GetMapping("boardInsert")
	public String bInsert() {
		return "bInsert";
	}
	
	//추가하기
	@PostMapping("boardInsert")
	public String bInsert(StarterBoard board) {
		bservice.boardSave(board);
		return "redirect:boardList";
	}
	
	//게시판
	@GetMapping("boardList")
	public String bList(Model model,
			@PageableDefault(size=3, sort="num", direction = Sort.Direction.DESC)
			Pageable pageable) {
		Page<StarterBoard> blist=bservice.bList(pageable);
		model.addAttribute("blist",blist);
		return "bList";
	}
	
	//상세보기
	@GetMapping("view/{num}")
	public String bView(@PathVariable Long num, Model model) {
		model.addAttribute("board", bservice.bView(num));
		return "bView";
	}
	
	//수정하기
	@PutMapping("view/{num}/update")
	@ResponseBody
	public String update(@PathVariable Long num, @RequestBody StarterBoard board) {
		bservice.bUpdate(board);
		return num.toString();
	}
	
	//삭제하기
	@DeleteMapping("view/{num}/delete")
	@ResponseBody
	public String delete(@PathVariable Long num) {
		bservice.delete(num);
		return num.toString();
	}
}
