package com.myboard.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.dto.CommentDTO;
import com.myboard.model.CommentService;
import com.myboard.model.CommentServiceImpl;

@RequestMapping("/reply/")
@RestController//controller+responsebody
public class CommentController {

	@Autowired
	private CommentService cservice;
	
	//리스트
	@GetMapping("commentList")
	public List<CommentDTO> list(int bnum) {
		List<CommentDTO> clist = cservice.getList(bnum);
		return clist;
	}
	
	//댓글쓰기
	@PostMapping("commentInsert")
	public String insert(@RequestBody CommentDTO comment) {
		//json으로 넘긴 값을 @RequestBody가 작동되어 bean객체에 매핑되어 insert 처리
		cservice.insert(comment);
		return "success";
	}
	
	//삭제 cDlete
	@GetMapping("commentDelete")
	public String delete(int cnum) {
		cservice.delete(cnum);
		return "success";
	}
	
	//삭제 fdel
	@DeleteMapping("/del/{cnum}")
	public int fdel(@PathVariable int cnum) {
		cservice.delete(cnum);
		return cnum;
	}
}
