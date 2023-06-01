package com.ons.study.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ons.study.service.QnAContentService;

import jakarta.servlet.http.HttpSession;
import com.ons.study.dto.UserDTO;

@Controller
public class QnABoardController {
	
	@Autowired
	QnAContentService service;
	
	// 질문 게시판 목록 확인
	@GetMapping("/qnaboard")
	public String qnaBoard(Model model, 
			@RequestParam(value="page", required=false, defaultValue="1") int page,
			HttpSession session) {
		isLogin(model, session);
		model.addAttribute("qnaLists", service.getQnaContentByPage(page));
		model.addAttribute("qnaContentsTotalCount", service.getQnaContentTotalCount());
		model.addAttribute("pageLimit", QnAContentService.PAGE_LIMIT);
		return "QnABoard";
	}
	
	@GetMapping("/qnawrite")
	public String qnaWrite(Model model, HttpSession session) {
		isLogin(model, session);
		if (session.getAttribute("user") != null) {
			return "QnABoardWrite";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/qnapostview")
	public String qnaPostView(Model model,
			@RequestParam(value="id", required=true) String id,
			HttpSession session) {
		if (id == null || id.isEmpty()) {
			// 요청 파라미터가 입력되지 않았을 경우 질문 게시판으로 이동.
            return "redirect:/qnaboard";   
        } else {
        	isLogin(model, session);
        	long idLong = Long.parseLong(id);
        	model.addAttribute("qnaContent", service.getQnaContentById(idLong));
        	model.addAttribute("tags", service.getTagsByContentId(idLong));
        	model.addAttribute("comments", service.getCommentsById(idLong));
        	// 요청 파라미터가 입력되었을 경우.
        	return "QnAPostView";        	
        }
	}
	
	private void isLogin(Model model, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		if (user != null) model.addAttribute("user", user);
	}
}
