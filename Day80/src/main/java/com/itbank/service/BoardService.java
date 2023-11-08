package com.itbank.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itbank.component.Paging;
import com.itbank.model.BoardDAO;
import com.itbank.model.vo.BoardVO;

/*
	Transaction
	- 단일 작업으로 동작해야 하는 논리적인 작업의 묶음 단위
	- 물리적으로 여러개의 Query문이 마치 하나의 Query문 처럼 동작하도록 한다
	
	ACID
	1. 원자성 (Atomicity)		: 분리할 수 없는 하나의 단위. 해당 작업은 모두 실행 혹은 모두 실패 해야한다
	2. 일관성 (Consistency)	: 실행 전과 후에 DB는 일관된 상태를 유지해야 한다
	3. 격리성 (Isolation)		: 서로 다른 트랜잭션끼리 간섭 불가
	4. 지속성 (Durability)		: 정상 종료시 데이터는 영구적으로 보관되어야 한다
*/

@Service
public class BoardService {
	
	@Autowired private BoardDAO dao;
	
	@Transactional(readOnly = true)						// select문과 같은 조회문에 readOnly를 적용하면
	public Map<String, Object> getBoards(Integer reqPage) {	// 불필요한 작업을 줄여 성능 향상 및 최적화가 된다
		
		reqPage = (reqPage == null) ? 1 : reqPage;
		Paging p = new Paging(reqPage, dao.selectTotal());
		
		Map<String, Object> result = new HashMap<>();
		result.put("p", p);
		result.put("list", dao.selectAll(p));
		
		return result;
	}

	@Transactional(readOnly = true)
	public BoardVO getBoard(int idx) {
		return dao.selectOne(idx);
	}
	
	@Transactional
	public String writeBoard(BoardVO input) {
		int row = dao.insert(input);
		String path = "";
		
		if (row != 0) {
			int idx = dao.selectLast();
			System.out.println("idx = " + idx);
			
			path += "view/" + idx;
		}
		
		return path;
	}
	
	@Transactional		// 아래 메서드를 하나의 트랜잭션으로 실행
	public void txTestRun() {
		dao.testInsert();
		dao.testInsert();
		dao.testInsert();
		
		if (1 == 1) {
			throw new NullPointerException();
		}
		
		dao.testInsert();
		dao.testInsert();
	}

	
}
