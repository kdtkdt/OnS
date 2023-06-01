package com.ons.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ons.study.dto.CommentDTO;

@Mapper
@Repository
public interface CommentDAO {
	public List<CommentDTO> getCommentsById(long contentId);
	public String getUserNicknameById(long userId);
}
