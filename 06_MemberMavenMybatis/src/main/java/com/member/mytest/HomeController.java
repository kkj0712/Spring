package com.member.mytest;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.member.model.Member;
import com.member.model.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "insert";
	}
	
	//추가 폼으로 가기
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	//추가하기
	@PostMapping("insert")
	public String insert(Member member) {
		service.insert(member);
		return "redirect:list";
	}
	
	//전체보기
	@RequestMapping("list")
	public String list(Model model, 
			@RequestParam(value="field", required = false)String field, 
			@RequestParam(value="word", required = false)String word) {
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		List<Member> mlist=service.list(hm);
		model.addAttribute("memberlist", mlist);
		return "list";
	}
	
	//상세보기, 수정 폼으로 가기
	@RequestMapping(value={"view", "update"})
	public void view(Model model, String id) {
		Member member=service.findById(id);
		model.addAttribute("member", member);
	}
	
	//수정하기
	@PostMapping("update")
	public String update(Member member) {
		service.update(member);
		return "redirect:list";
	}
	
	//삭제하기
	@RequestMapping("delete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:list";
	}
	
	@GetMapping("sample1")
	@ResponseBody
	public String sample() {
		return "success";
	}
}
