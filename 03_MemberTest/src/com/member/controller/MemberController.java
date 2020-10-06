package com.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAOImpl dao;
	
	//추가 폼으로 가기
	@RequestMapping(value="member_insert.me",method=RequestMethod.GET)
	public String insert() {
		return "memberForm";
	}
	
	//추가
	@RequestMapping(value="member_insert.me",method=RequestMethod.POST)
	public String insert(MemberDTO user) {
		dao.insert(user);
		return "redirect:member_list.me";
	}
	
	//전체보기
	@RequestMapping("member_list.me")
	public String memberList(Model model, String id) {
		List<MemberDTO> memberlist=dao.getMemberList();
		model.addAttribute("memberlist", memberlist);
		return "memberList";
	}
	
	//상세보기
	@RequestMapping("member_view.me")
	public String view (Model model, String id) {
		MemberDTO m=dao.findById(id);
		model.addAttribute("member",m);
		return "memberView";
	}
	
	//수정하기 폼으로 이동
	@RequestMapping(value="member_update.me", method=RequestMethod.GET)
	public String update(Model model, String id) {
		MemberDTO m=dao.findById(id);
		model.addAttribute("user",m);
		return "updateForm";
	}
	
	//수정하기
	@RequestMapping(value="member_update.me", method=RequestMethod.POST)
	public String update(MemberDTO user) {
		dao.update(user);
		return "redirect:member_list.me";
	}
	
	//삭제하기
	@RequestMapping("member_delete.me")
	public String delete(String id) {
		dao.delete(id);
		return "redirect:member_list.me";
	}
	
	
}
