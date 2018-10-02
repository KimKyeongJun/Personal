package com.ktds.qna.reply.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.qna.reply.dao.QnaReplyDao;
import com.ktds.qna.reply.vo.QnaReplyVO;

@Component
public class QnaReplyBizImpl implements QnaReplyBiz {
	
	@Autowired
	private QnaReplyDao qnaReplyDao;
	
	@Override
	public boolean registOneQnaReply(QnaReplyVO qnaReplyVO) {
		return this.qnaReplyDao.insertOneQnaReply(qnaReplyVO) > 0;
	}
	
	@Override
	public List<QnaReplyVO> selectOneQnaAllReply(String qnaId) {
		return this.qnaReplyDao.selectOneQnaAllReply(qnaId);
	}

}
