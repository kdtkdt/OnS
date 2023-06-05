package com.ons.study.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



import com.ons.study.dto.CommentDTO;
import com.ons.study.dto.RecruitmentDTO;
import com.ons.study.dto.StudyDTO;

@Mapper
@Repository
public interface RecruitmentDAO {
	public List<RecruitmentDTO> recruitmentList();
	public List<RecruitmentDTO> recruitmentList2();
	public List<RecruitmentDTO> recruitmentList3();
	public RecruitmentDTO recruitmentpostview(int id);
	public int insertStudyGroup(StudyDTO studyDTO);
	public int insertContent(RecruitmentDTO dto);
	public int insertBoard(RecruitmentDTO dto);
	public int insertSkill(RecruitmentDTO dto);
	public int deleteContent(int id);
	public int deleteStudyGroup(int id);
	public int deleteSkill(int id);
	
	
}
