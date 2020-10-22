package com.myguest.myguest;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
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

import com.myguest.model.GuestBookDTO;
import com.myguest.model.GuestBookService;
import com.myguest.model.GuestListVO;
import com.myguest.util.PageAction;

@Controller
public class HomeController {
	@Autowired
	private GuestBookService service;
	@Autowired
	private PageAction page;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "insert";
	}
	
	//추가하기
	@PostMapping("gInsert")
	public String insert(HttpServletRequest req, GuestBookDTO gb) {
		gb.setIpaddr(req.getRemoteAddr());
		service.guestInsert(gb);
		return "redirect:gList";
	}
	
	//전체보기
	@GetMapping("gList")
	@ResponseBody
	//json형태로 return 시켜준다는 걸 어떻게 알까? 자동적으로 컨버터가 호출되어서 제이슨 형태로 변환된다. 그래서 객체를 그대로 리턴시켜주면 된다.
	//String이 아니라 다양한 객체들이 return 되어질 수 있음. 
	public GuestListVO list(String pageNum, String field, String word) {
		HashMap<String, Object> hm=new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		
		int count=service.countGuest(hm);
		int pageSize=5; //한 화면에 보여지는 게시글 수
		if(pageNum==null) pageNum="1"; 
		int currentPage=Integer.parseInt(pageNum);
		
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=startRow+pageSize-1;
		if(endRow>count) endRow=count;
		
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		
		List<GuestBookDTO> list=service.list(hm);
		String pageHtml=page.paging(count, pageSize, currentPage, field, word);
		GuestListVO listvo=new GuestListVO(count, list, pageHtml);
		return listvo;
	}
	
	@GetMapping("gView")
	@ResponseBody
	public GuestBookDTO view(int num) {
		GuestBookDTO gb=service.findByNum(num);
		//내부적으로 converter를 거치기 때문에 제이슨Object을 만들필요가 없다.
		return gb;
	}
	
	//삭제하기
	@GetMapping("gDelete")
	@ResponseBody
	public String delete(int num) {
		service.deleteGuest(num);
		return "success";
	}
	
}