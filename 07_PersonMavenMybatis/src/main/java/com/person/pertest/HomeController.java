package com.person.pertest;

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

import com.person.model.Person;
import com.person.model.PersonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private PersonService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "redirect:list";
	}
	
	//추가폼으로 가기
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	//추가하기
	@PostMapping("insert")
	public String insert(Person person) {
		service.insert(person);
		return "redirect:list";
	}
	
	//전체보기
	@RequestMapping("list")
	public String list(Model model, 
			@RequestParam(value="field", required=false)String field, 
			@RequestParam(value="word", required=false)String word) {
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		List<Person>plist=service.list(hm);
		model.addAttribute("personlist", plist);
		
		int count=service.count();
		model.addAttribute("count", count);
		return "list";
	}
	
	//상세보기, 수정 폼으로 가기
	@RequestMapping(value={"detail", "update"})
	public void detail(Model model, String id) {
		Person person=service.detail(id);
		model.addAttribute("user", person);
	}
	
	//수정하기
	@PostMapping("update")
	public String update(Person person) {
		service.update(person);
		return "redirect:list";
	}
	
	//삭제하기
	@RequestMapping("delete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:list";
	}
}
