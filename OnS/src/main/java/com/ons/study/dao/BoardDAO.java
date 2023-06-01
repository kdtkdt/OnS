package com.ons.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ons.study.dto.BoardDTO;

@Mapper
@Repository
public interface BoardDAO {
	
	public List<BoardDTO> getTotalBoard() ;
	public int writeBoard(BoardDTO dto);

}