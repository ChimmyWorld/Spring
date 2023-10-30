package com.itbank.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.dto.BoardDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired private BoardService bs;
	
	@GetMapping("/view")
	public ModelAndView view(int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("view", bs.updateViewCount(idx));
		mav.addObject("row", bs.getBoard(idx));
		
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {	
	}
	
	@PostMapping("/write")
	public ModelAndView write(BoardDTO input) {
		ModelAndView mav = new ModelAndView("msg");
		
		mav.addObject("row", bs.writeBoard(input));
		mav.addObject("message", "작성 완료");
		
		return mav;
	}	
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", bs.getBoard(idx));
		mav.setViewName("board/write");
		
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public ModelAndView update(BoardDTO input) {
		// 만약 동일한 이름의 필드가 VO에 있으면 자동으로 받아진다
		
		ModelAndView mav = new ModelAndView("msg");
		
		mav.addObject("row", bs.updateBoard(input));
		mav.addObject("message", "수정 완료");
		
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("msg");
		
		mav.addObject("row", bs.deleteBoard(idx));
		mav.addObject("message", "삭제 완료");
		
		return mav;
	}

	// 예외는 보통 service나 DAO에서 발생
		// 여기서 발생한 예외는 보통 controller까지 전가가 된다
		// controller에서도 예외를 처리하지 않으면 에러 페이지가 출력된다
		
		// 아래는 현재 컨트롤러에서 발생하는 예외를 처리할 메서드를 지정
		@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
		public ModelAndView ex() {
			ModelAndView mav = new ModelAndView("msg");
			
			mav.addObject("row", 0);
			mav.addObject("message", "작성 실패");
			
			return mav;
		}
}
