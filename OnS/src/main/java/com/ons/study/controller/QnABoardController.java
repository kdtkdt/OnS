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
}
