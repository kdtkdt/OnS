package com.ons.study.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



import com.ons.study.dto.CommentDTO;
import com.ons.study.dto.RecruitmentDTO;
@Mapper
@Repository
public interface RecruitmentDAO {
	public List<RecruitmentDTO> recruitmentList();
	public List<RecruitmentDTO> recruitmentList2();
	public List<RecruitmentDTO> recruitmentList3();
	public RecruitmentDTO recruitmentpostview(int id);
	public List<RecruitmentDTO> postviewcomment(int id);
	public List<CommentDTO> commentuserinfo(int id);
	
	
}
