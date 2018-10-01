package com.ktds.qna.reply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.qna.reply.dao.QnaReplyDao;
import com.ktds.qna.reply.vo.QnaReplyVO;

@Service
public class QnaReplyServiceImpl implements QnaReplyService {
	
	@Autowired
	private QnaReplyDao qnaReplyDao;
	
	@Override
	public boolean registOneQnaReply(QnaReplyVO qnaReplyVO) {
		return this.qnaReplyDao.insertOneQnaReply(qnaReplyVO) > 0;
	}

}
