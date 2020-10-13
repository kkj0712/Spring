package com.member.mytest;

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
	
	//�߰� ������ ����
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	//�߰��ϱ�
	@PostMapping("insert")
	public String insert(Member member) {
		service.insert(member);
		return "redirect:list";
	}
	
	//��ü����
	@RequestMapping("list")
	public String list(Model model, String field, String word) {
		field=field==null? "":field;
		word=word==null? "":word;
		List<Member> mlist=service.list(field, word);
		model.addAttribute("memberlist", mlist);
		return "list";
	}
	
	//�󼼺���, ���� ������ ����
	@RequestMapping(value={"view", "update"})
	public void view(Model model, String id) {
		Member member=service.findById(id);
		model.addAttribute("member", member);
	}
	
	//�����ϱ�
	@PostMapping("update")
	public String update(Member member) {
		service.update(member);
		return "redirect:list";
	}
	
	//�����ϱ�
	@RequestMapping("delete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:list";
	}
}
