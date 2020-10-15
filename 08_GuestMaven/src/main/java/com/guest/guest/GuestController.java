package com.guest.guest;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guest.model.GuestService;
import com.guest.vo.GuestVO;

@Controller
public class GuestController {
	@Autowired
	private GuestService service;
	
	@GetMapping("gInsert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("gInsert")
	public String insert(HttpServletRequest req, GuestVO guest) {
		guest.setIpaddr(req.getRemoteAddr());
		service.insert(guest);
		return "redirect:gList";
	}
	
	@GetMapping("gList")
	public String list(Model model, String field, String word) {
		HashMap<String, Object> hm=new HashMap<>();
		hm.put("field", field);
		hm.put("word", word);
		List<GuestVO> list=service.list(hm); 
		model.addAttribute("guestlist", list);
		return "list";
	}
}
