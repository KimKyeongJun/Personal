package com.ktds.qna.reply.dao;

import java.util.List;

import com.ktds.qna.reply.vo.QnaReplyVO;

public interface QnaReplyDao {
	
	public int insertOneQnaReply(QnaReplyVO qnaReplyVO);
	
	public List<QnaReplyVO> selectOneQnaAllReply(String qnaId);

}
