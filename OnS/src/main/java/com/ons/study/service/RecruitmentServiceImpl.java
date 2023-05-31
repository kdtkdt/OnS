package com.ons.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ons.study.dao.RecruitmentDAO;
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




	

}
