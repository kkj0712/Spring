package com.myboard.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.dto.BoardDTO;
import com.myboard.model.BoardListDTO;
import com.myboard.model.BoardService;
import com.myboard.model.PageAction;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private BoardService service;
	
	@Autowired
	private PageAction page;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@PostMapping("boardInsert")
	public String insert(BoardDTO board) {
		service.insert(board);
		return "redirect:boardList";
	}
	
	@GetMapping("boardList")
	@ResponseBody
	public BoardListDTO list(String pageNum, String field, String word) {
		HashMap<String, Object> hm=new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		
		int count=service.count(hm);
		int pageSize=5; //한 화면에 보여지는 게시글 수
		if(pageNum==null) pageNum="1";
		int currentPage=Integer.parseInt(pageNum);
		
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=startRow+pageSize-1;
		if(endRow>count) endRow=count;
		
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		
		List<BoardDTO> list=service.findAll(hm);
		String pageHtml=page.paging(count, pageSize, currentPage, field, word);
		BoardListDTO boardlist=new BoardListDTO(count, list, pageHtml);
		return boardlist;
	}
	
	@GetMapping("boardView")
	@ResponseBody
	public BoardDTO view(int num) {
		BoardDTO board=service.findByNum(num);
		return board;
	}
	
	@GetMapping("boardDelete")
	@ResponseBody
	public String delete(int num) {
		service.delete(num);
		return "success";
	}
	
}
