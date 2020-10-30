package com.myboard.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.dto.MemberDTO;
import com.myboard.model.MemberServiceImpl;

@RequestMapping("/member/")
@Controller
public class MemberController {
	
	@Autowired
	private MemberServiceImpl mService;
	
	//멤버폼으로
	@GetMapping("join")
	public String toJoin() {
		return "join";
	}
	
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestBody MemberDTO member) {
		mService.join(member);
		return "success";
	}
	
	//아이디체크
	@GetMapping("idcheck")
	@ResponseBody
	public int idCheck(String id) {
		int idCount = mService.idCheck(id);
		return idCount;
	}
	
	//로그인폼으로
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	//로그인
	@PostMapping("login")
	@ResponseBody
	public String login(String id, String pass, HttpServletRequest request) {
		MemberDTO member = mService.loginCheck(id);
		String result="";
		if(member==null) {//회원아님
			result="no";
		}else if(member.getPass().equals(pass)) {//로그인성공
			HttpSession session = request.getSession();
			session.setAttribute("sessionDto", member);
			result="success";
		}else {//비번오류
			result="passError";
		}
		return result;
	}
	
	

}
