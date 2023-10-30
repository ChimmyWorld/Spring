package com.itbank.model;

import java.util.List;

import com.itbank.model.dto.ReplyDTO;

public interface ReplyDAO {
	List<ReplyDTO> selectReplyAll(int board_idx);
	
	int insertReply(ReplyDTO input);

	int countOne(int idx);
	
}
