package com.ons.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ons.study.dao.CommentDAO;
import com.ons.study.dao.QnAContentDAO;
import com.ons.study.dto.CommentDTO;
import com.ons.study.dto.QnAContentDTO;

@Service
public class QnAContentService {
	public static final int PAGE_LIMIT = 8;
	@Autowired
	QnAContentDAO contentsDao;
	@Autowired
	CommentDAO commentsDao;
	
	public List<QnAContentDTO> getQnaContentByPage(int page) {
		List<QnAContentDTO> dtoList = contentsDao.getQnaContentByPage((page-1) * PAGE_LIMIT, PAGE_LIMIT);
		for (var dto : dtoList) {
			dto.setTags(contentsDao.getTagsByContentId(dto.getId()));
		}
		return dtoList;
	}
	
	public QnAContentDTO getQnaContentById(long contentId) {
		QnAContentDTO dto = contentsDao.getQnaContentById(contentId);
		dto.setTags(contentsDao.getTagsByContentId(dto.getId()));
		return dto;
	}
	
	public long getQnaContentTotalCount() {
		return contentsDao.getQnaContentTotalCount();
	}
	
	public String[] getTagsByContentId(long contentId) {
		return contentsDao.getTagsByContentId(contentId);
	}
	
	public List<CommentDTO> getCommentsById(long contentId) {
		List<CommentDTO> dtoList = commentsDao.getCommentsById(contentId);
		for (var dto : dtoList) {
			long userId = dto.getUserId();
			dto.setNickname(commentsDao.getUserNicknameById(userId));
		}
		return dtoList;
	}
}
