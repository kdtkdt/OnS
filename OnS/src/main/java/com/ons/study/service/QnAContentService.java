package com.ons.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ons.study.dao.QnAContentDAO;
import com.ons.study.dto.QnAContentDTO;

@Service
public class QnAContentService {
	public static final int PAGE_LIMIT = 8;
	@Autowired
	QnAContentDAO dao;
	
	public List<QnAContentDTO> getQnaContentByPage(int page) {
		List<QnAContentDTO> dtoList = dao.getQnaContentByPage((page-1) * PAGE_LIMIT, PAGE_LIMIT);
		for (var dto : dtoList) {
			dto.setTags(dao.getTagsByContentId(dto.getId()));
		}
		return dtoList;
	}
	
	public long getQnaContentTotalCount() {
		return dao.getQnaContentTotalCount();
	}
	
	public String[] getTagsByContentId(long contentId) {
		return dao.getTagsByContentId(contentId);
	}
}
