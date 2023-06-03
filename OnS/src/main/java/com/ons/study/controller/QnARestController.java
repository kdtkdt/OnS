package com.ons.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ons.study.dto.QnAContentDTO;
import com.ons.study.dto.UserDTO;
import com.ons.study.service.QnAContentService;

import jakarta.servlet.http.HttpSession;

@RestController
public class QnARestController {
	
	@Autowired
	QnAContentService qnaContentService;
	
	@PostMapping("/api/qna/write")
	public ResponseEntity<QnAContentDTO> saveNewQna(@RequestBody QnAContentDTO qnaContent, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		final int insertCount = qnaContentService.insertQnaContent(qnaContent);
		final long userIdFromClient = qnaContent.getUserId();
		if (user != null && user.getId() == userIdFromClient && insertCount == 1) {
			final long newQnaContentId = qnaContentService.getLastContentIdByUser(userIdFromClient);
			for (String tagName : qnaContent.getTags()) {
				qnaContentService.insertTag(tagName, newQnaContentId);
			}
			qnaContent = new QnAContentDTO();
			qnaContent.setId(newQnaContentId);
			return ResponseEntity.ok(qnaContent);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
