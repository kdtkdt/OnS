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
    	
		System.out.println(dto.getId());
		ModelAndView mv = new ModelAndView();
		mv.addObject("comments", qnaContentService.getCommentsById(id));
		mv.addObject("postviewlist",dto);
//		mv.addObject("commentlist",dto2);
//		mv.addObject("commentinfo",dto3);
//		mv.addObject("commentcount",commentcount);
//		Date date = java.sql.Timestamp.valueOf(dto2.get(id).getComment().getCreatedTime());
//		mv.addObject("date",date);
		mv.setViewName("recruitment/postview");	
		return mv;
	}
	
	@RequestMapping("/recruit/boardwrite")
	public String boardwrite() {
		return "recruitment/boardwrite";	
	}
	
	@PostMapping("/recruit/boardwrite")
	public String writeprocess(RecruitmentDTO dto) {
		System.out.println(dto.getStudy().getStart_date());
//		service.insertStudyGroup(dto);
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
//		RecruitmentDTO dto = service.recruitmentpostview(id);
//		List<RecruitmentDTO> dto2 = service.postviewcomment(id);
//		List<CommentDTO> dto3 = service.commentuserinfo(id);
//		int commentcount = service.commentcount(id);
		ModelAndView mv = new ModelAndView();
//		mv.addObject("postviewlist",dto);
//		mv.addObject("commentlist",dto2);
//		mv.addObject("commentinfo",dto3);
//		mv.addObject("commentcount",commentcount);
//		Date date = java.sql.Timestamp.valueOf(dto2.get(1).getComment().getCreatedTime());
//		mv.addObject("date",date);	
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
}
