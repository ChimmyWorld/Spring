package com.itbank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.components.Paging;
import com.itbank.model.BoardDAO;
import com.itbank.model.dto.BoardDTO;
import com.itbank.model.dto.ReplyDTO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;

	public String getVer() {
		return dao.test();
	}
	
	//게시글 관련
	public Map<String, Object> getBoards(Integer idx) {
		idx = idx == null ? 1 : idx;
		
		// 페이징 코드 작성
		Paging p = new Paging(idx, dao.totalBoard());
		List<BoardDTO> list = dao.selectAll(p);
		
		// 타입이 다른 객체를 묶어서 반환하기 위해 Map을 사용
		Map<String, Object> result = new HashMap<>();
		
		result.put("p", p);
		result.put("list", list);
		
		return result;
	}

	public int writeBoard(BoardDTO input) {
		return dao.insert(input);
	}
	
	public int deleteBoard(int idx) {
		return dao.delete(idx);
	}

	public BoardDTO getBoard(int idx) {
		return dao.selectOne(idx);
	}

	public int updateBoard(BoardDTO input) {
		return dao.update(input);
	}
	
	public int updateViewCount(int idx) {
		return dao.countUp(idx);
	}
	
}
