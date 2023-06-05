package com.ons.study.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ons.study.dto.CommentDTO;
import com.ons.study.dto.RecruitmentDTO;
import com.ons.study.service.QnAContentService;
import com.ons.study.service.RecruitmentService;



@Controller
public class RecruitmentController {
	@Autowired
	@Qualifier("recruitmentServiceImpl")
	RecruitmentService service;
	
	@Autowired
	QnAContentService qnaContentService;
	
	@RequestMapping("/recruitmentlist")
	public ModelAndView recruitmentList() {
		List<RecruitmentDTO> dto = service.recruitmentList();
		List<RecruitmentDTO> dto2 = service.recruitmentList2();
		List<RecruitmentDTO> dto3 = service.recruitmentList3();
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardlist",dto);
		mv.addObject("boardlist2",dto2);
		mv.addObject("boardlist3",dto3);
		mv.setViewName("recruitment/boardlist");	
		return mv;
	}
	
	@RequestMapping("/recruit/recruitmentpostview")
	public ModelAndView recruitmentpostview(@RequestParam(value="id", required=false, defaultValue="1") int id) {
		RecruitmentDTO dto = service.recruitmentpostview(id);
		System.out.println(dto.getSkill().getStudy_group_id());
		ModelAndView mv = new ModelAndView();
		mv.addObject("comments", qnaContentService.getCommentsById(id));
		mv.addObject("postviewlist",dto);
		mv.setViewName("recruitment/postview");	
		return mv;
	}
	
	@RequestMapping("/recruit/boardwrite")
	public String boardwrite() {
		return "recruitment/boardwrite";	
	}
	
	@PostMapping("/recruit/boardwrite")
	public String writeprocess(RecruitmentDTO dto) {
		service.insertContent(dto);
		
		
		return "redirect:/recruitmentlist";
	}
	
	@RequestMapping("/recruit/recruitmentwriteresult")
	public String recruitmentwriteresult(@RequestParam(value="id", required=false, defaultValue="1") int id) {
		if(id == 1) {
			System.out.println("생성입니다.");
		}else {
			System.out.println("수정입니다.");
		}
		ModelAndView mv = new ModelAndView();
		return "redirect:/recruitmentlist";
	}
	
	@RequestMapping("/recruit/postviewedit")
	public ModelAndView postviewedit(@RequestParam(value="id", required=false, defaultValue="1") int id) {
		RecruitmentDTO dto = service.recruitmentpostview(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("postviewlist",dto);
		mv.setViewName("recruitment/postviewedit");	
		return mv;
	}
	
	@RequestMapping("/recruit/postviewdelete")
	public String postviewdelete( int groupid , int contentid) {
		service.deleteContent(contentid);
		service.deleteSkill(groupid);
		return "redirect:/recruitmentlist";
	}
}
