package com.guest.guest;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guest.model.GuestService;
import com.guest.util.PageAction;
import com.guest.vo.GuestVO;

@Controller
public class GuestController {
	@Autowired
	private GuestService service;
	
	@Autowired
	private PageAction page;
	
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
	public String list(Model model, String pageNum, String field, String word) {
		HashMap<String, Object> hm=new HashMap<>(); //String과 int값이 들어가야하니까 Object
		hm.put("field", field);
		hm.put("word", word);
		
		int count=service.count(hm); //게시글 수 ex)23개 
		int pageSize=5; //한 화면에 보여지는 수
		if(pageNum==null) pageNum="1"; //페이지 수
		int currentPage=Integer.parseInt(pageNum); //현재 페이지
		
		int startRow=(currentPage-1)*pageSize+1; //시작 페이지
		int endRow=startRow+pageSize-1; //끝 페이지
		if(endRow>count) endRow=count; //마지막 허수 처리
		
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		
		String pageHtml=page.paging(count, pageSize, currentPage, field, word); //[이전] 4 5 6 [다음] =>글자
		
		List<GuestVO> list=service.list(hm); 
		model.addAttribute("count", count);
		model.addAttribute("guestlist", list);
		model.addAttribute("pageHtml", pageHtml);
		return "list";
	}
	
	//상세보기 (JSON의 객체가 return 되어야함)
	@GetMapping(value="gView", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String view(@RequestParam("num")int num) {
		GuestVO guest=service.findById(num);
		JSONObject obj=new JSONObject();
		obj.put("name", guest.getName());
		obj.put("content", guest.getCreated());
		obj.put("grade", guest.getGrade());
		obj.put("ipaddr", guest.getIpaddr());
		obj.put("created", guest.getCreated());
		return obj.toString(); //obj.jsp를 찾음. 전달하고자 하는 문자열인 경우 responsebody를 쓴다.
	}
	
	//삭제하기
	@GetMapping("gDelete")
	public String delete(int num) {
		service.delete(num);
		return "redirect:gList";
	}
}
