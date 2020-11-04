package com.myspring.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.dto.CommentDTO;
import com.myspring.service.CommentService;


@RequestMapping("/reply/")
//controller+responsebody
@RestController
public class CommentController {
	@Autowired
	private CommentService cservice;
	
	@GetMapping("commentList")
	public List<CommentDTO> list(int bnum) {
		List<CommentDTO> clist = cservice.getList(bnum);
		return clist;
	}
	
	@PostMapping("commentInsert")
	public String insert(@RequestBody CommentDTO comment) {
		cservice.insert(comment);
		return "success";
	}
	
	@GetMapping("commentDelete")
	public String delete(int cnum) {
		cservice.delete(cnum);
		return "success";
	}
	
	@DeleteMapping("/del/{cnum}")
	public int fdel(@PathVariable int cnum) {
		cservice.delete(cnum);
		return cnum;
	}
}
