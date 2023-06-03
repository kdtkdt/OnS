package com.ons.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/api/qna/modify")
	public ResponseEntity<QnAContentDTO> updateQna(@RequestBody QnAContentDTO qnaContent, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		final long userIdFromClient = qnaContent.getUserId();
		if (user != null && user.getId() == userIdFromClient) {
			if (qnaContentService.updateQnaContent(qnaContent) < 1) {
				return ResponseEntity.ok(new QnAContentDTO());
			}
			
			long contentId = qnaContent.getId();
			// 기존 태그 삭제
			qnaContentService.deleteTagByContentId(contentId);
			if (qnaContent.getTags().length > 0) {
				// 태그 추가
				for (String tagName : qnaContent.getTags()) {
					qnaContentService.insertTag(tagName, contentId);
				}
			}
			
			qnaContent = new QnAContentDTO();
			qnaContent.setId(contentId);
			return ResponseEntity.ok(qnaContent);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/api/qna/delete")
	public ResponseEntity<Boolean> deleteQna(@RequestBody QnAContentDTO qnaContent, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		final long userIdFromClient = qnaContent.getUserId();
		if (user != null && user.getId() == userIdFromClient) {
			// 질문 삭제
			if (qnaContentService.deleteQnaContentById(qnaContent.getId()) < 1) {
				return ResponseEntity.ok(false);
			}
			
			// 태그는 ON DELETE CASCADE로 설정해두어 자동 삭제됨
			
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
