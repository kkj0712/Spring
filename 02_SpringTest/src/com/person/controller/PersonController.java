package com.person.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.person.model.Person;
import com.person.model.PersonDAOImpl;

@Controller
public class PersonController {
	@Autowired
	private PersonDAOImpl dao;

	//�߰���
	@RequestMapping(value="personInsert.go",method=RequestMethod.GET)
	public String insert() {
		return "personForm";
	}    
	
	//�߰�
	@RequestMapping(value="personInsert.go",method=RequestMethod.POST)
	public String insert(Person p) {
		dao.personInsert(p);
		return "redirect:personList.go";
	}
	
	//��ü����
	@RequestMapping("personList.go")
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mv=new ModelAndView();
		List<Person> userlist=dao.personList();
		mv.addObject("userlist", userlist);
		mv.setViewName("personList");
		return mv;
	}
	
	//�󼼺���
	@RequestMapping("personView.go")
	protected ModelAndView view (String id) {
		ModelAndView mv=new ModelAndView();
		Person p=dao.personView(id);
		mv.addObject("user", p);
		mv.setViewName("personView");
		return mv;
	}
	
	//�����ϱ� ������ ����
	@RequestMapping(value="update.go",method=RequestMethod.GET)
	public String personUpdate(Model model, String id) {
		Person p=dao.personView(id);
		model.addAttribute("user", p);
		return "updateForm";
	}
	
	//�����ϱ�
	@RequestMapping(value="update.go",method=RequestMethod.POST)
	public String personUpdate(Person p) {
		dao.personUpdate(p);
		return "redirect:personList.go";
	}
	
	//�����ϱ�
	@RequestMapping("personDelete.go")
	public String personDelete(String id) {
		dao.personDelete(id);
		return "redirect:personList.go";
	}
}
