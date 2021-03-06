package com.mycom.mymember;

import java.text.DateFormat;
import java.util.Date;
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

import com.mycom.model.Member;
import com.mycom.model.MemberService;

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
	//루트 실행시 회원가입 창이 나오도록
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "insert";
	}
	
	//추가 폼으로 이동
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	//추가
	@PostMapping("insert")
	public String insert(Member member) {
		service.insert(member);
		return "redirect:list";
	}
	
	//전체
	@RequestMapping("list")
	public String list(Model model, String field, String word){
		field=field==null? "":field;
		word=word==null? "":word;
		List<Member> mlist=service.list(field,word);
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
	@RequestMapping(value="update", method=RequestMethod.POST)
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
	
}
