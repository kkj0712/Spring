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
		HashMap<String, Object> hm=new HashMap<>(); //String�� int���� �����ϴϱ� Object
		hm.put("field", field);
		hm.put("word", word);
		
		int count=service.count(hm); //�Խñ� �� ex)23�� 
		int pageSize=5; //�� ȭ�鿡 �������� ��
		if(pageNum==null) pageNum="1"; //������ ��
		int currentPage=Integer.parseInt(pageNum); //���� ������
		
		int startRow=(currentPage-1)*pageSize+1; //���� ������
		int endRow=startRow+pageSize-1; //�� ������
		if(endRow>count) endRow=count; //������ ��� ó��
		
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		
		String pageHtml=page.paging(count, pageSize, currentPage, field, word); //[����] 4 5 6 [����] =>����
		
		List<GuestVO> list=service.list(hm); 
		model.addAttribute("count", count);
		model.addAttribute("guestlist", list);
		model.addAttribute("pageHtml", pageHtml);
		return "list";
	}
	
	//�󼼺��� (JSON�� ��ü�� return �Ǿ����)
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
		return obj.toString(); //obj.jsp�� ã��. �����ϰ��� �ϴ� ���ڿ��� ��� responsebody�� ����.
	}
	
	//�����ϱ�
	@GetMapping("gDelete")
	public String delete(int num) {
		service.delete(num);
		return "redirect:gList";
	}
}
