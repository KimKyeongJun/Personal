package com.ktds.qna.reply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.qna.reply.biz.QnaReplyBiz;
import com.ktds.qna.reply.vo.QnaReplyVO;

@Service
public class QnaReplyServiceImpl implements QnaReplyService {
	
	@Autowired
	private QnaReplyBiz qnaReplyBiz;
	
	@Override
	public boolean registOneQnaReply(QnaReplyVO qnaReplyVO) {
		return this.qnaReplyBiz.registOneQnaReply(qnaReplyVO);
	}

}
