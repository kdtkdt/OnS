package com.ons.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ons.study.dto.MemberDTO;
import com.ons.study.dto.RecruitmentDTO;
import com.ons.study.service.RecruitmentService;

@Controller
public class RecruitmentController {
	@Autowired
	@Qualifier("recruitmentServiceImpl")
	RecruitmentService service;
	
	@RequestMapping("/recruitmentlist")
	public ModelAndView recruitmentList() {
		List<RecruitmentDTO> list = service.recruitmentList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist",list);
		mv.setViewName("recruitment/boardlist");	
		return mv;
	}
}
