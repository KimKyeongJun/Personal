package com.ktds.qnareply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.qnareply.dao.QnaReplyDao;
import com.ktds.qnareply.vo.QnaReplyVO;

@Service
public class QnaReplyServiceImpl implements QnaReplyService {
	
	@Autowired
	private QnaReplyDao qnaReplyDao;
	
	@Override
	public boolean registOneQnaReply(QnaReplyVO qnaReplyVO) {
		return this.qnaReplyDao.insertOneQnaReply(qnaReplyVO) > 0;
	}

}
