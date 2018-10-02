package com.ktds.qna.reply.biz;

import java.util.List;

import com.ktds.qna.reply.vo.QnaReplyVO;

public interface QnaReplyBiz {
	
	public boolean registOneQnaReply(QnaReplyVO qnaReplyVO);
	
	public List<QnaReplyVO> selectOneQnaAllReply(String qnaId);

}
