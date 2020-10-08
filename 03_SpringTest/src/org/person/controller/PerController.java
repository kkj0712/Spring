package org.person.controller;

import java.util.List;

import org.person.model.PersonService;
import org.person.model.PersonServiceImpl;
import org.person.model.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PerController {
	//index에서 Controller로 넘어왔고, Service를 연결시켜줘야한다.
	@Autowired
	private PersonService service; 
	
	//추가 폼으로 가기
	@RequestMapping(value="insert.go", method=RequestMethod.GET)
	public String insert() {
		return "personForm";
	}
	
	//추가하기
	@RequestMapping(value="insert.go", method=RequestMethod.POST)
	public String insert(PersonVO person) {
		service.person_insert(person);
		return "redirect:list.go";
	}
	
	//전체보기
	@RequestMapping("list.go")
	public String list(Model model) {
		List<PersonVO> userlist=service.person_list();
		model.addAttribute("personlist", userlist);
		return "personList";
	}
	
	//상세보기, 수정폼 (void는 url그대로 넘어감)
	@RequestMapping(value= {"detail.go", "update.go"})
	public void view(Model model, String id) {
		PersonVO person=service.person_detail(id);
		model.addAttribute("user", person);
	}
	
	//수정하기
	@RequestMapping(value="update.go", method=RequestMethod.POST)
	public String update(PersonVO p) {
		service.person_update(p);
		return "redirect:list.go";
	}
	
	//삭제하기
	@RequestMapping("delete.go")
	public String delete(String id) {
		service.person_delete(id);
		return "redirect:list.go";
	}
}
