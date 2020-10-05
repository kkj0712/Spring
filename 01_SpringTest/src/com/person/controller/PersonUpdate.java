package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonDTO;

public class PersonUpdate extends AbstractController{

	private PersonDAOImpl dao;
	
	//setter
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PersonDTO person=new PersonDTO();
		person.setGender(req.getParameter("gender"));
		person.setJob(req.getParameter("job"));
		person.setName(req.getParameter("name"));
		person.setPassword(req.getParameter("password"));
		person.setId(req.getParameter("id"));
		dao.personUpdate(person);
		return new ModelAndView("redirect:personList.sp");
	}

}
