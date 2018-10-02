package com.ktds.qna.service;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.qna.biz.QnaBiz;
import com.ktds.qna.reply.biz.QnaReplyBiz;
import com.ktds.qna.reply.vo.QnaReplyVO;
import com.ktds.qna.vo.QnaSearchVO;
import com.ktds.qna.vo.QnaVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaBiz qnaBiz;
	@Autowired
	private QnaReplyBiz qnaReplyBiz;

	@Override
	public boolean createQna(QnaVO qnaVO) {
		return this.qnaBiz.createQna(qnaVO);
	}

	@Override
	public QnaVO readOneQna(String qnaId) {
		QnaVO qnaVO = this.qnaBiz.readOneQna(qnaId);
		List<QnaReplyVO> qnaReplyList = this.qnaReplyBiz.selectOneQnaAllReply(qnaId);
		qnaVO.setQnaReplyList(qnaReplyList);		
		return qnaVO;
	}

	@Override
	public PageExplorer readAllQna(QnaSearchVO qnaSearchVO) {		
		return this.qnaBiz.readAllQna(qnaSearchVO);
	}

}
