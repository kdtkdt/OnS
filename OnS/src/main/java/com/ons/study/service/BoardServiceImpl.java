package com.ons.study.service;

import com.ons.study.dao.BoardDAO;
import com.ons.study.dto.BoardDTO;

import java.util.HashMap;
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

	@Override
	public BoardDTO getOneBoard(int id) { //게시글 한개 조회
		return boardDAO.getOneBoard(id);
	}

	@Override
	public List<BoardDTO> pagingBoard(int[] limit) {
		return boardDAO.pagingBoard(limit);
	}

	@Override
	public int totalBoardCnt() {
		return boardDAO.totalBoardCnt();
	}

	@Override
	public int plusViewCount(int id) {
		return boardDAO.plusViewCount(id);
	}

	@Override
	public int deleteBoard(int id) {
		return boardDAO.deleteBoard(id);
	}

	//검색된 게시글 리스트
	@Override
	public List<BoardDTO> searchBoard(HashMap<String, Object> map){
		return boardDAO.searchBoard(map);
	}

	//검색된 게시글수
	@Override
	public int searchBoardCnt(HashMap<String, Object> map) {
		return boardDAO.searchBoardCnt(map);
	}

	//게시물 수정
	@Override
	public int updateBoard(BoardDTO dto) { 
		return boardDAO.updateBoard(dto);
	}

	


}

