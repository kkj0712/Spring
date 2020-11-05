package com.example.demo5.controller;

import java.util.List;

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

import com.example.demo5.model.Member;
import com.example.demo5.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String index() {
		return "home";
	}
	
	@GetMapping("mInsert")
	public String mInsert() {
		return "insert";
	}
	
	@PostMapping("mInsert")
	public String mInsert(Member member) {
		memberService.save(member);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String list(Model model,
			//id를 기준으로 내림차순하고 3페이지씩 표시
			@PageableDefault(size=3, sort="id", direction=Sort.Direction.DESC)
			Pageable pageable) {
		Page<Member> mlist=memberService.list(pageable);
		model.addAttribute("list", mlist);
		return "list";
	}
	
	//상세보기
	@GetMapping("{id}")
	public String findById(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.detail(id));
		return "detail";
	}
	
	//수정폼으로 이동
	@GetMapping("{id}/update")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.detail(id));
		return "update";
	}
	
	//수정하기
	@PutMapping("update/{id}")
	@ResponseBody
	public String update(@PathVariable Long id, @RequestBody Member member) {
		System.out.println("addr:"+member.getAddr());
		System.out.println("id:"+member.getId());
		System.out.println("name:"+member.getName());
		memberService.update(member);
		return id.toString();
	}
	
	//삭제하기
	@DeleteMapping("{id}") //a 태그를 이용해서 전달할 수 없다.
	@ResponseBody //json형태로 return. 이걸 안적으면 view 이름을 써줘야함
	public String delete(@PathVariable Long id) {
		memberService.delete(id);
		return id.toString();
	}
}
