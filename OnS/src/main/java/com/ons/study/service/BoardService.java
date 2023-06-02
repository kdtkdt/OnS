package com.ons.study.service;

import java.util.HashMap;
import java.util.List;

import com.ons.study.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> getTotalBoard();
	public int writeBoard(BoardDTO dto);
	public BoardDTO getOneBoard(int id);
	public List<BoardDTO> pagingBoard(int[] limit);
	public int totalBoardCnt();
	public List<BoardDTO> searchBoard(HashMap<String, Object> map);
	public int plusViewCount(int id) ;
	 public int deleteBoard(int id) ;
		public int searchBoardCnt(HashMap<String, Object> map);
		public int updateBoard(BoardDTO dto);

}
