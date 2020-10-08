package com.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.member.model.MemberService;
import com.member.model.MemberVO;

@Controller
public class MemberController {
	//서비스 연결
	@Autowired
	private MemberService mService;
	
	//추가폼으로 가기
	@RequestMapping("insert.my")
	public void insert() {
		
	}
	
	//추가하기
	@RequestMapping(value="insert.my", method=RequestMethod.POST)
	public String insert(MemberVO member) {
		mService.insert(member);
		return "redirect:list.my";
	}
	
	//전체보기
	@RequestMapping("list.my")
	public String list(Model model) {
		List<MemberVO> memberlist=mService.list();
		model.addAttribute("memberlist", memberlist);
		return "memberList";
	}
	
	//상세보기, 수정폼
	@RequestMapping(value={"view.my","update.my"})
	public void view(Model model, String id) {
		MemberVO member=mService.view(id);
		model.addAttribute("member", member);
	}
	
	//수정하기
	@RequestMapping(value="update.my", method=RequestMethod.POST)
	public String update(MemberVO member) {
		mService.update(member);
		return "redirect:list.my";
	}
	
	//삭제하기
	@RequestMapping("delete.my")
	public String delete(String id) {
		mService.delete(id);
		return "redirect:list.my";
	}
	
}
