package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itbank.component.Paging;
import com.itbank.model.vo.BoardVO;
import com.itbank.model.vo.ReplyVO;

public interface BoardDAO {
	@Select("select count(*) from board")
	int selectTotal();

	@Select("select * from board "
			+ "order by idx desc "
			+ "offset #{offset} rows "
			+ "fetch first #{perCount} rows only")
	List<BoardVO> selectAll(Paging p);

	@Insert("insert into board(contents) values('1')")
	void testInsert();

	@Select("select * from board where idx = #{idx}")
	BoardVO selectOne(int idx);

	@Insert("insert into "
			+ "board(title, writer, contents) "
			+ "values(#{title}, #{writer}, #{contents})")
	int insert(BoardVO input);
	
	@Select("select idx from board "
			+ "order by idx desc "
			+ "fetch first ROW only")
	int selectLast();

	@Select("select * from reply where board_idx = #{idx} "
			+ "order by idx desc")
	List<ReplyVO> selectReply(int idx);
}
