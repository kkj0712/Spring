package com.example.demo6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.dto.CommentDTO;
import com.example.demo6.model.StarterBoard;
import com.example.demo6.model.StarterComment;
import com.example.demo6.service.CommentService;

@RequestMapping("/reply/")
@RestController
public class CommentController {
	@Autowired
	private CommentService cservice;
	
	//댓글 목록 불러오기
	@GetMapping("cList")
	public List<StarterComment> comList(Long bnum){
		List<StarterComment> clist=cservice.getcomList(bnum);
		System.out.println(clist.size());
		return clist;
	}
	
	//댓글쓰기
	@PostMapping("cInsert")
	public String comInsert(@RequestBody CommentDTO comment) {
		cservice.com_Insert(comment);
		return "success";
	}
}
