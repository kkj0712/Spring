package com.person.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonDTO;

public class PersonList extends AbstractController{
	private PersonDAOImpl dao;
		
	//setter
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv=new ModelAndView();
		List<PersonDTO> userlist=dao.findAll();
		mv.addObject("userlist",userlist);
		mv.setViewName("WEB-INF/jsp/personList.jsp");
		return mv;
	}
	
}