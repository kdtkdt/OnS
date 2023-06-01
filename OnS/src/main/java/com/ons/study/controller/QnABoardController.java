package com.ons.study.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ons.study.service.QnAContentService;

@Controller
public class QnABoardController {
	
	@Autowired
	QnAContentService service;
	
	// 질문 게시판 목록 확인
	@GetMapping("/qnaboard")
	public String qnaBoard(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {
		model.addAttribute("qnaLists", service.getQnaContentByPage(page));
		model.addAttribute("qnaContentsTotalCount", service.getQnaContentTotalCount());
		model.addAttribute("pageLimit", QnAContentService.PAGE_LIMIT);
		return "QnABoard";
	}
	
	@GetMapping("/qnawrite")
	public String qnaWrite() {
		return "QnABoardWrite";
	}
	
	@GetMapping("/qnapostview")
	public String qnaPostView(Model model, @RequestParam(value="id", required=true) String id) {
		if (id == null || id.isEmpty()) {
			// 요청 파라미터가 입력되지 않았을 경우 질문 게시판으로 이동.
            return "redirect:/qnaboard";   
        }
		
		// 요청 파라미터가 입력되었을 경우.
        return "QnAPostView";
	}
}
