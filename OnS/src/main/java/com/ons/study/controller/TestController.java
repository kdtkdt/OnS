package com.ons.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ons.study.dto.BoardDTO;
import com.ons.study.service.BoardService;

@Controller
public class TestController {

	@Autowired
	@Qualifier("boardServiceImpl")
	BoardService boardService;

	 @RequestMapping("/reviewboard") 
	 public ModelAndView getTotalBoard() {
	 List<BoardDTO> totalList = boardService.getTotalBoard();
	 
	 ModelAndView mv = new ModelAndView(); 
	 mv.addObject("totalList", totalList);
	 mv.setViewName("reviewboardlist"); 
	 return mv; 
	 }
	 
	 @GetMapping("/reviewboardwrite")
	 public String writeform() {
		 return "reviewboardwrite";
	 }
	 
	 @PostMapping("/reviewboardwrite")
	 public String writeBoard(BoardDTO dto) {
		boardService.writeBoard(dto);
		return "redirect:/reviewboard";
	 }

	 
}
