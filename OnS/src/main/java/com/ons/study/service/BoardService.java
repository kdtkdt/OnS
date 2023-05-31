package com.ons.study.service;

import java.util.List;

import com.ons.study.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> getTotalBoard();
	public int writeBoard(BoardDTO dto);

}
