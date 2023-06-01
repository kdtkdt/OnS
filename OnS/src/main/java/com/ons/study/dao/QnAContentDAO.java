package com.ons.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ons.study.dto.QnAContentDTO;


@Mapper
@Repository
public interface QnAContentDAO {
	
	public List<QnAContentDTO> getQnaContentByPage(int startRow, int pageSize);
	public String[] getTagsByContentId(long contentId);
	public long getQnaContentTotalCount();
}