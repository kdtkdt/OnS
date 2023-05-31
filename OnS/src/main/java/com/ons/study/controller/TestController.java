package com.ons.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ons.study.service.MemberService;

@Controller
public class TestController {
	
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService memberService;
	
	@RequestMapping("/test")
	public String test(Model model) {
		model.addAttribute("ons", "ons");
		model.addAttribute("mybatis", memberService.oneMember("mybatis").getName());
		return "test";
	}
}
