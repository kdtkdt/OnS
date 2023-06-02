package com.ons.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ons.study.dao.RecruitmentDAO;
import com.ons.study.dto.CommentDTO;
import com.ons.study.dto.RecruitmentDTO;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
	@Autowired
	RecruitmentDAO dao;

	
	@Override
	public List<RecruitmentDTO> recruitmentList() {
		// TODO Auto-generated method stub
		return dao.recruitmentList();
	}

	@Override
	public List<RecruitmentDTO> recruitmentList2() {
		// TODO Auto-generated method stub
		return dao.recruitmentList2();
	}
	
	@Override
	public List<RecruitmentDTO> recruitmentList3() {
		// TODO Auto-generated method stub
		return dao.recruitmentList3();
	}

	@Override
	public RecruitmentDTO recruitmentpostview(int id) {
		// TODO Auto-generated method stub
		return dao.recruitmentpostview(id);
	}

	@Override
	public List<RecruitmentDTO> postviewcomment(int id) {
		// TODO Auto-generated method stub
		return dao.postviewcomment(id);
	}

	@Override
	public List<CommentDTO> commentuserinfo(int id) {
		// TODO Auto-generated method stub
		return dao.commentuserinfo(id);
	}

	

}
