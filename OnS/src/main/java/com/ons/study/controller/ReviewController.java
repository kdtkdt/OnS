package com.ons.study.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ons.study.dto.BoardDTO;
import com.ons.study.service.BoardService;

@Controller
public class ReviewController {

	@Autowired
	@Qualifier("boardServiceImpl")
	BoardService boardService;

	// 1 전체 게시글 조회
	@RequestMapping("/reviewboard")
	public ModelAndView getTotalBoard(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		int totalBoardCnt = boardService.totalBoardCnt();

		int limitcount = 12;
		int limitindex = (page - 1) * limitcount;
		int[] limit = new int[2];
		limit[0] = limitindex;
		limit[1] = limitcount;
		List<BoardDTO> totalPagingList = boardService.pagingBoard(limit);

		ModelAndView mv = new ModelAndView();
		mv.addObject("totalPagingList", totalPagingList);
		mv.addObject("totalBoardCnt", totalBoardCnt);
		mv.setViewName("reviewboardlist");
		return mv;
	}

	// 검색한 게시글 조회
	@RequestMapping("/searchboard")
	public ModelAndView searchBoard(String item, String searchword) {

		// 검색 조건으로 검색한 게시글 리스트, 게시글수
		HashMap<String, Object> map = new HashMap<>();

		if (item.equals("제목")) {
			map.put("colname", "title");
		}
		if (item.equals("내용")) {
			map.put("colname", "contents");
		}
		if (item.equals("인강사이트명")) {
			map.put("colname", "lecture_sitename");
		}
		map.put("colvalue", "%" + searchword + "%");

		List<BoardDTO> searchlist = boardService.searchBoard(map);
		int searchBoardCnt = boardService.searchBoardCnt(map);

		ModelAndView mv = new ModelAndView();
		mv.addObject("totalPagingList", searchlist);
		mv.addObject("totalBoardCnt", searchBoardCnt);
		mv.setViewName("reviewboardlist");
		return mv;
	}

	// 2 게시글 작성 페이지 이동
	@GetMapping("/reviewboardwrite")
	public String writeform() {
		return "reviewboardwrite";
	}

	// 2-1 게시글 작성 + 전체 게시글 조회 페이지로 이동
	@PostMapping("/reviewboardwrite")
	public String writeBoard(BoardDTO dto) {
		boardService.writeBoard(dto);
		return "redirect:/reviewboard";
	}

	// 게시글 한개 조회
	@RequestMapping(value = "/reviewpostview", method = RequestMethod.GET)
	public ModelAndView getOneBoard(@RequestParam("id") int id) {
		BoardDTO onedto = boardService.getOneBoard(id);
		boardService.plusViewCount(id);

		ModelAndView mv = new ModelAndView();
		mv.addObject("onedto", onedto);
		mv.setViewName("reviewpostview");
		return mv;
	}

	@RequestMapping("/deleteboard")
	public String deleteBoard(@RequestParam("id") int id) {
		int row = boardService.deleteBoard(id);
		return "redirect:/reviewboard";
	}

	@GetMapping("/updateboard")
	public ModelAndView updateBoardForm(@RequestParam("id") int id) { // 수정폼으로 이동
		BoardDTO dto = boardService.getOneBoard(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.addObject("id", id);
		mv.setViewName("reviewboardupdate");
		return mv;
	}

	@PostMapping("/updateboard")
	public String updateBoard(BoardDTO dto) { // 게시글 수정

		int row = boardService.updateBoard(dto);
		return "redirect:/reviewboard";

	}
	// 전체 게시글 수 조회
	
	

}
