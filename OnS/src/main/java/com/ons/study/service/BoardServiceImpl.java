package com.ons.study.service;

import com.ons.study.dao.BoardDAO;
import com.ons.study.dto.BoardDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO boardDAO;

	public List<BoardDTO> getTotalBoard() { //전체 리스트 조회
		return boardDAO.getTotalBoard();
	}

	@Override
	public int writeBoard(BoardDTO dto) {	//글 작성
		return boardDAO.writeBoard(dto);
	}

	


}

