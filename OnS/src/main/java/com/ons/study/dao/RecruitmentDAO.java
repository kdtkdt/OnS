package com.ons.study.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ons.study.dto.RecruitmentDTO;
@Mapper
@Repository
public interface RecruitmentDAO {
	public List<RecruitmentDTO> recruitmentList();
}
