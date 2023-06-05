package com.ons.study.service;

import java.util.List;

import com.ons.study.dto.CommentDTO;
import com.ons.study.dto.RecruitmentDTO;


public interface RecruitmentService {
	public List<RecruitmentDTO> recruitmentList();
	public List<RecruitmentDTO> recruitmentList2();
	public List<RecruitmentDTO> recruitmentList3();
	public RecruitmentDTO recruitmentpostview(int id);
	public int insertContent(RecruitmentDTO dto);
	public int deleteContent(int id);
	public int deleteSkill(int id);
}
