package com.myboard.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.dto.BoardDTO;
import com.myboard.dto.BoardListDTO;
import com.myboard.model.BoardService;
import com.myboard.model.BoardServiceImpl;
import com.myboard.model.PageAction;

@Controller
public class HomeController {
	@Autowired
	private BoardServiceImpl service;
	
	@Autowired
	private PageAction page;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "redirect:boardList";
	}
	
	//추가 페이지로 이동
	@GetMapping("boardInsert")
	public String insertPage() {
		return "insert";
	}
	
	//추가하기
	@PostMapping("boardInsert")
	public String insert(BoardDTO board) {
		service.insert(board);
		return "redirect:boardList";	
	}
	
	//전체리스트
	@GetMapping("boardList")
	public String list(Model model, String pageNum, String field, String word) {
		HashMap<String, Object> hm = new HashMap<>();
		
		//검색
		hm.put("field", field);
		hm.put("word", word);
		
		//갯수
		int count = service.count(hm);
		
		//페이징
		int pageSize =5;//한 화면에 보여지는 수
		if(pageNum==null) pageNum="1";	
		int currentPage = Integer.parseInt(pageNum);//현재페이지
		int startRow = (currentPage-1)*pageSize+1;//첫 행
		int endRow = startRow+pageSize-1; //마지막 행
		if(endRow>count) endRow=count; //마지막 게시글

		hm.put("startRow",startRow);
		hm.put("endRow", endRow);
		
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);
		
		//리스트
		List<BoardDTO> list = service.findAll(hm);
				
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageHtml", pageHtml);		
		
		return "list";		
	}
	
	//검색
	@GetMapping("searchList")
	@ResponseBody
	public BoardListDTO search(Model model, String pageNum, String field, String word) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("field", field);
		hm.put("word", word);			
		
		//갯수
		int count = service.count(hm);
		
		//페이징
		int pageSize =5;//한 화면에 보여지는 수
		if(pageNum==null) pageNum="1";	
		int currentPage = Integer.parseInt(pageNum);//현재페이지
		int startRow = (currentPage-1)*pageSize+1;//첫 행
		int endRow = startRow+pageSize-1; //마지막 행
		if(endRow>count) endRow=count; //마지막 게시글

		hm.put("startRow",startRow);
		hm.put("endRow", endRow);
		
		//리스트
		List<BoardDTO> list = service.findAll(hm);
		
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);
		
		//객체형으로 반환
		BoardListDTO listDTO = new BoardListDTO(count, list, pageHtml);		
		
		return listDTO;		
	}
	
	//상세보기
	@GetMapping("get/{num}")
	public void get(@PathVariable("num") int num, Model model) {
		BoardDTO board = service.findByNum(num);
		model.addAttribute("board", board);
	}
	
	@GetMapping({"view","update"})
	public void view(Model model, int num) {
		BoardDTO board = service.findByNum(num);
		model.addAttribute("board", board);
	}	
	
	//수정하기
	@PostMapping("update")
	public String update(BoardDTO board) {
		service.update(board);
		return "redirect:boardList";
	}
	
	//삭제하기
	@GetMapping("boardDelete")
	public String delete(int num) {
		service.delete(num);		
		return "redirect:boardList";
	}
	
}
