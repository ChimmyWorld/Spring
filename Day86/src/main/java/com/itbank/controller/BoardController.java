package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.BoardVO;
import com.itbank.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@GetMapping
	public List<BoardVO> getBoards(int reqPage){
		System.out.println("reqPage = " + reqPage);
		return bs.getBoards(reqPage);
	}
	
	@PostMapping
	public int addBoard(@RequestBody(required = false) BoardVO input) {
		return bs.addBoard(input);
	}
	
	@PutMapping
	public int updateBoard(@RequestBody BoardVO input) {
		return bs.updateBoard(input);
	}
	
	@PatchMapping
	public int updateBoardTitle(@RequestBody BoardVO input) {
		return bs.updateBoardTitle(input);
	}
	
	@DeleteMapping("/{idx}")
	public int deleteBoard(@PathVariable int idx) {
		return bs.deleteBoard(idx);
	}
	
	@GetMapping("/{idx}")
	public BoardVO getBoard(@PathVariable int idx) {
		return bs.getBoard(idx);
	}
}
