package com.itbank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.components.Paging;
import com.itbank.model.BoardDAO;
import com.itbank.model.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	
	public Map<String, Object> getBoards(int reqPage) {
		Paging p = new Paging(reqPage, dao.totalBoard());
		List<BoardVO> list = dao.selectAll(p);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("p", p);
		
		return map;
	}

	public int addBoard(BoardVO input) {
		return dao.insert(input);
	}

	public int updateBoard(BoardVO input) {
		return dao.update(input);
	}

	public int updateBoardTitle(BoardVO input) {
		return dao.updateTitle(input);
	}

	public int deleteBoard(int idx) {
		return dao.delete(idx);
	}

	public BoardVO getBoard(int idx) {
		return dao.selectOne(idx);
	}


}
